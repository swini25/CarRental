package com.neu.swini.rentCarProject.controller;

import com.neu.swini.rentCarProject.dao.BookingDAO;
import com.neu.swini.rentCarProject.dao.CarDao;
//import com.neu.swini.rentCarProject.dao.CarPhotoDAO;
import com.neu.swini.rentCarProject.pojo.Booking;
import com.neu.swini.rentCarProject.pojo.Car;
//import com.neu.swini.rentCarProject.pojo.CarPhoto;
import com.neu.swini.rentCarProject.pojo.Customer;
import com.neu.swini.rentCarProject.validator.BookCarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@Controller
public class BookCarController {


    @Autowired
    BookCarValidator bookCarValidator;

    @Autowired
    CarDao carDao;

//    @Autowired
//    CarPhotoDAO carPhotoDAO;

    @GetMapping ("/bookCar.htm")
//    public String viewCarsGet(ModelMap model, Booking booking, CarPhoto carPhoto, HttpSession session) throws Exception {
    public String viewCarsGet(ModelMap model, Booking booking, HttpSession session) throws Exception {

        if (manageSession(session)) return "home";
        CarDao carDao = new CarDao();
        List<Car> carList = carDao.list();
        for(int i=0; i<carList.size();i++){
            if(!carList.get(i).isAvailable()){
                carList.remove(i);
            }
        }

        model.addAttribute("booking", booking);
        model.addAttribute("list", carList);
        System.out.println();
        return "bookCars";
    }

    @PostMapping("/bookCar.htm")
    public String bookCarPost(HttpSession session , BookingDAO bookingDAO, @ModelAttribute("booking") Booking booking, HttpServletRequest request, BindingResult result) throws Exception{

        bookCarValidator.validate(booking,result);
        if(result.hasErrors()){
            return "errorPage";
        }
        CarDao carDao= new CarDao();
        request.getSession();
        Customer customer1 = (Customer) session.getAttribute("customer");

        List<Booking> myBookings = bookingDAO.list(customer1.getEmail());
        for(int i=0; i< myBookings.size(); i++){
            if(myBookings.get(i).isStatus()){
                request.setAttribute("error", "Already have a booking");
                return "errorPage";
            }
        }

        String licenseNumber =  request.getParameter("check");
        if(licenseNumber.isEmpty()){
            request.setAttribute("error", "Car Not Selected");
            return "bookCars";
        }

        //Adding data to the booking order
        booking.setCustomerEmail(customer1.getEmail());
        booking.setCarLicenseNo(licenseNumber);
        String startDate= request.getParameter("startDate");
        String returnDate = request.getParameter("returnDate");
        booking.setStartDate(startDate);
        booking.setReturnDate(returnDate);
        booking.setStatus(true);
        Car car = carDao.getCarByLicenseNo(licenseNumber);
        booking.setPrice(car.getPrice());


        //Calculating the total price for a booking
        double daysDiff =  daysDifference(startDate, returnDate);
        double totalPrice =  car.getPrice()*daysDiff;
        if(totalPrice ==0) totalPrice = car.getPrice();
        booking.setTotalPrice(totalPrice);


        //Setting the booked car availability as false
        car.setAvailable(false);
        carDao.updateCar(car);
        bookingDAO.createUserBooking(booking);

        return "bookingSuccess";
    }

    @GetMapping("/myBookings.htm")
    public String myBookings(ModelMap model, Booking booking, BookingDAO bookingDAO,HttpSession session, HttpServletRequest request) throws Exception{

        if (manageSession(session)) return "home";
        request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        List<Booking> myBookings = bookingDAO.list(customer.getEmail());

        model.addAttribute("bookingList" , myBookings);

        return "myBookings";
    }

    @GetMapping("/modifyMyBooking.htm")
    public String modifyMyBookingGet(ModelMap model, HttpSession session,HttpServletRequest request) throws Exception{
        if (manageSession(session)) return "home";
        request.getSession();
        Customer customer1 = (Customer)session.getAttribute("customer");

        BookingDAO bookingDAO = new BookingDAO();
        Booking booking = bookingDAO.getBookingForCust(customer1.getEmail());

        try{
            model.addAttribute("bookingDetails",booking);
            return "currentBooking";
        }
        catch (Exception e){
            return "errorPage";
        }

    }

    @PostMapping("/modifyMyBooking.htm")
    public String modifyMyBookingPost(HttpSession session, HttpServletRequest request,  @ModelAttribute("bookingDetails") Booking booking, BookingDAO bookingDAO){
        request.getSession();
        Customer customer1 = (Customer)session.getAttribute("customer");
        String bookingId = request.getParameter("check");
        try{
            Booking booking1 = bookingDAO.getbyBookingId(Integer.parseInt(bookingId));

            booking1.setStartDate(request.getParameter("startDate"));
            booking1.setReturnDate(request.getParameter("returnDate"));
            double daysDiff = daysDifference(request.getParameter("startDate"), request.getParameter("returnDate"));
            Car car = carDao.getCarByLicenseNo(booking1.getCarLicenseNo());
            double price = car.getPrice();
            double  totalPrice = price*daysDiff;
            if(totalPrice ==0) totalPrice = car.getPrice();
            booking1.setTotalPrice(totalPrice);
            bookingDAO.updateBookingStatus(booking1);

            return "customerPage";
        }
        catch(Exception e){
            return "errorPage";
        }
    }


    @GetMapping("/searchCars.htm")
    public String searchCars(ModelMap model, Booking booking, HttpSession session, HttpServletRequest request){

        model.addAttribute("bookingCars" , booking);
    return "searchCars";
    }
    //Calculate the difference in start and end date
    public double daysDifference(String startDate, String returnDate) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date dateBefore = simpleDateFormat.parse(startDate);
        Date dateAfter = simpleDateFormat.parse(returnDate);
        long timeDifference = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        double daysDifference = TimeUnit.DAYS.convert(timeDifference, TimeUnit.MILLISECONDS);

        return daysDifference;
    }

    private boolean manageSession(HttpSession session) {
        Customer customer = null;
        if(session.getAttribute("customer") != null) {
            customer = (Customer)session.getAttribute("customer");
        }

        if(customer == null) {
            System.out.println("");
            return true;
        }
        if(customer.getCategory().equals("carOwner")){
            return true;
        }

        return false;
    }

}

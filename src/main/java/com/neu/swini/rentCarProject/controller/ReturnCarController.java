package com.neu.swini.rentCarProject.controller;


import com.neu.swini.rentCarProject.dao.BookingDAO;
import com.neu.swini.rentCarProject.dao.CarDao;
import com.neu.swini.rentCarProject.pojo.Booking;
import com.neu.swini.rentCarProject.pojo.Car;
import com.neu.swini.rentCarProject.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReturnCarController {

    @Autowired
    CarDao daoCar;

    @Autowired
    BookingDAO daoBooking;

    @GetMapping("/returnCar.htm")
    public String getCar(ModelMap modelMap, Booking bookingUsingEmail, HttpSession session, HttpServletRequest request) throws Exception{
        if (sessionManage(session)) return "home";
        request.getSession();
        Customer cust = (Customer)session.getAttribute("customer");

        BookingDAO bookingDAO = new BookingDAO();
        bookingUsingEmail = bookingDAO.getBookingForCust(cust.getEmail());
        modelMap.addAttribute("bookingDetails",bookingUsingEmail);

        return "returnCar";
    }

    @PostMapping("/returnCar.htm")
    public String postCar(HttpSession session, HttpServletRequest request, @ModelAttribute("bookingDetails") Booking booking)throws Exception{

        request.getSession();
//        Customer customer1 = (Customer)session.getAttribute("customer");
        String bookingId = request.getParameter("check");
        try{
            Booking book = daoBooking.getbyBookingId(Integer.parseInt(bookingId));

            book.setStatus(false);
            daoBooking.updateBookingStatus(book);

            Car car = daoCar.getCarByLicenseNo(book.getCarLicenseNo());
            car.setAvailable(true);
            daoCar.updateCar(car);
            return "returnSuccessful";
        }
        catch(Exception e){
            return "errorPage";
        }
    }

    private boolean sessionManage(HttpSession session) {
        Customer cust = null;
        if(session.getAttribute("customer") != null) {
            cust = (Customer)session.getAttribute("customer");
        }
        if(cust == null) {
            return true;
        }
        if(cust.getCategory().equals("carOwner")){
            return true;
        }
        return false;
    }


}

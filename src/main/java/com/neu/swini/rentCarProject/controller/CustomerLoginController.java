package com.neu.swini.rentCarProject.controller;


import com.neu.swini.rentCarProject.dao.CustomerDAO;
import com.neu.swini.rentCarProject.exception.CustomerException;
import com.neu.swini.rentCarProject.pojo.Customer;
import com.neu.swini.rentCarProject.validator.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerLoginController {



    @GetMapping("/customer/login.htm")
    public String checkLoginGet(ModelMap model, Customer customer, HttpSession session, HttpServletRequest request){

        model.addAttribute("customer", customer);
        return "login-form";
    }

    @PostMapping("/customer/login.htm")
    public String checkLoginPost(HttpSession session , @ModelAttribute("customer") Customer customer, SessionStatus status, HttpServletRequest request, BindingResult result) throws Exception{

        LoginValidator loginValidator = new LoginValidator();

        loginValidator.validate(customer, result);

        if(result.hasErrors()){
            return "login-form";
        }

        String returnView = null;
        if(customer.getEmail() == null || customer.getEmail().equals("")) {
            request.setAttribute("error", "Invalid EmailId");
            System.out.println("invalid email");
            return "login-form";
        }

        if(customer.getPassword() == null || customer.getPassword().equals("")) {
            request.setAttribute("error", "Invalid Password");
            System.out.println("invalid password");
            return "login-form";
        }
        Customer customer1 = null;
        if(customer.getCategory().equals("customer")){

            try{
                CustomerDAO customerDAO = new CustomerDAO();
                customer1 = customerDAO.getCustomer(customer.getEmail(), customer.getCategory());
            }catch(CustomerException e){
                System.out.println("Error" + e.getMessage());
                return "login-form";
            }
            returnView = "customerPage";

        }
        else if(customer.getCategory().equals("carOwner")){

            try{
                CustomerDAO customerDAO = new CustomerDAO();
                customer1 = customerDAO.getCustomer(customer.getEmail(), customer.getCategory());
            }catch(CustomerException e){
                System.out.println("Error" + e.getMessage());

                return "login-form";
            }
            returnView = "carOwnerPage";

        }
        status.setComplete();

        if(customer1 == null ){
            request.setAttribute("error", "Invalid EmailId");
            System.out.println("invalid Email2");
            return "login-form";
        }
        else if(!customer1.getPassword().equals(customer.getPassword())){
            request.setAttribute("error", "Invalid Password");
            System.out.println("invalid password2");
            return "login-form";
        }
        else if(!customer1.getCategory().equals(customer.getCategory())){
            request.setAttribute("error", "Invalid Category" + customer.getCategory());
            System.out.println("invalid Category");
            return "login-form";
        }

        session.setAttribute("customer", customer1);

        return returnView;
    }

    @GetMapping("/Customer/logout.htm")
    public String customerLogOut(HttpSession session) throws Exception{
        session.removeAttribute("customer");
        return "home";
    }


}

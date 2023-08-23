package com.neu.swini.rentCarProject.controller;

import com.neu.swini.rentCarProject.dao.CustomerDAO;
import com.neu.swini.rentCarProject.pojo.Customer;
import com.neu.swini.rentCarProject.validator.RegistrationValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationController {

    @GetMapping("/register.htm")
    public String registerCustomerGet(ModelMap model, Customer customer){
        model.addAttribute("registerCustomer" , customer);
        return "register";
    }

    @PostMapping("/register.htm")
    public String registerCustomerGet(@ModelAttribute("registerCustomer") Customer customer, SessionStatus status, HttpServletRequest request, BindingResult result) throws Exception{

       RegistrationValidator registrationValidator = new RegistrationValidator();
       registrationValidator.validate(customer, result);

       if(result.hasErrors()){
           return "register";
       }

        CustomerDAO customerDAO1 = new CustomerDAO();
        List<Customer> customerList = customerDAO1.list();
        for(int i=0; i< customerList.size(); i++){
            if(request.getParameter("email").equals(customerList.get(i).getEmail()) && request.getParameter("category").equals(customerList.get(i).getCategory())){
                request.setAttribute("Error", "Email has already been used");
                return "register";
            }
        }

        try{
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.createCustomer(customer);
        }
        catch(Exception e){
            System.out.println("Cannot register User" + e);
            return "register";
        }

        status.setComplete();

        return "customerRegistered";
    }
}

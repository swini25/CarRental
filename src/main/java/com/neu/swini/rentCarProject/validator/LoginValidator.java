package com.neu.swini.rentCarProject.validator;

import com.neu.swini.rentCarProject.pojo.Customer;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz)  {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "email", "Invalid_Email", "Please Enter Your Email");
        ValidationUtils.rejectIfEmpty(errors, "password", "Invalid_Password", "Please Enter Your Password");
    }
}

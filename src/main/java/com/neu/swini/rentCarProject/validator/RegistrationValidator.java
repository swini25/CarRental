package com.neu.swini.rentCarProject.validator;

import com.neu.swini.rentCarProject.pojo.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors,"email","Invalid_Email", "Please Enter Your Email");
        ValidationUtils.rejectIfEmpty(errors,"password","Invalid_Password", "Please Enter Your Password");
        ValidationUtils.rejectIfEmpty(errors,"name","Invalid_name", "Please Enter Your Name");
        ValidationUtils.rejectIfEmpty(errors,"gender","Invalid_gender", "Please Enter Your Gender");
        ValidationUtils.rejectIfEmpty(errors,"license","Invalid_license", "Please Enter Your License Details");
        ValidationUtils.rejectIfEmpty(errors,"city","Invalid_city", "Please Enter Your City");
    }
}

package com.neu.swini.rentCarProject.validator;

import com.neu.swini.rentCarProject.pojo.Car;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddCarValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"company", "Invalid_Company", "Select a Company");
        ValidationUtils.rejectIfEmpty(errors,"model", "Invalid Model", "Enter a Model");
        ValidationUtils.rejectIfEmpty(errors,"makeYear", "Invalid Year", "Enter a Year");
        ValidationUtils.rejectIfEmpty(errors,"licenseNo", "Invalid License Number", "Enter a License Number");
        ValidationUtils.rejectIfEmpty(errors,"colour", "Invalid colour", "Enter a colour");
        ValidationUtils.rejectIfEmpty(errors,"price", "Invalid price", "Enter a price");

    }
}

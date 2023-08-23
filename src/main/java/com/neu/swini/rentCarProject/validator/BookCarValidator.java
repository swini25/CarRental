package com.neu.swini.rentCarProject.validator;

import com.neu.swini.rentCarProject.pojo.Booking;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookCarValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Booking.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "startDate", "Invalid-Date", "Please Select a Date");
        ValidationUtils.rejectIfEmpty(errors, "returnDate", "Invalid-Date", "Please Select a Date");

    }
}

package com.blood.validator;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.blood.pojo.Staff;
import com.blood.service.StaffService;

@Component
public class StaffValidator implements Validator {

    @Autowired
    private StaffService staffService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Staff.class.equals(aClass);
    }

    /*
     * validation for registration
     */
    @Override
    public void validate(Object o, Errors errors) {
        Staff staff = (Staff) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Field cannot be empty");
        if (staff.getUsername().length() > 20) {
            errors.rejectValue("username", "Too long");
        }
        if (staffService.getByUsername(staff.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (staff.getPassword().length() < 8 || staff.getPassword().length() > 32) {
            errors.rejectValue("password", "must be less than 32 characters and longer than 8");
        }

        if (!staff.getConfirmPassword().equals(staff.getPassword())) {
            errors.rejectValue("Confirmpassword", "Passwords don't match");
        

    }
}

}
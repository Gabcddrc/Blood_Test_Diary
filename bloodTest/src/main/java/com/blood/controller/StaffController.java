package com.blood.controller;

import com.blood.pojo.Staff;
import com.blood.service.StaffService;
import com.blood.validator.StaffValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@RestController
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("getUser")
    public Staff get(HttpSession session) throws Exception {
        Staff staff =(Staff)  session.getAttribute("staff");
        return staff;
    }

}

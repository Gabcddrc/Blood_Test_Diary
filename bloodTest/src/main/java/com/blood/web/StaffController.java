package com.blood.web;

import com.blood.pojo.Staff;
import com.blood.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

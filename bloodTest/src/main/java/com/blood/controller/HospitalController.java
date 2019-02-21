package com.blood.controller;

import javax.servlet.http.HttpSession;

import com.blood.pojo.Hospital;
import com.blood.service.HospitalService;

import org.apache.shiro.crypto.hash.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
    @Autowired
    HospitalService staffService; 

    @GetMapping("getHospital")
    public Hospital get(HttpSession session) throws Exception {
        Hospital staff = (Hospital)  session.getAttribute("hospital");
        return staff;
    }

}

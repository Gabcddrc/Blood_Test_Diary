package com.blood.controller;

import com.blood.pojo.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegisterController{

@RequestMapping(value = "/registration", method = RequestMethod.GET)
public String registrationFrom(WebRequest request, Model model){
    Staff staff = new Staff();
    model.addAttribute("register", staff);
    return "registration";
}

}
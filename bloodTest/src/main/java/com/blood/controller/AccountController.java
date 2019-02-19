package com.blood.controller;

import com.blood.pojo.Staff;
import com.blood.service.StaffService;
import com.blood.validator.StaffValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AccountController {

    @Autowired
    StaffService staffService;

    StaffValidator staffValidator;
    
    @RequestMapping(value="/login")
    public String getLogin(Model model, String error) {
        if (error != null)
        {model.addAttribute("error", "Your username and password is invalid.");}

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("staffForm", new Staff());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("staffForm") Staff staffForm, BindingResult bindingResult, Model model) {
        staffValidator.validate(staffForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        staffService.saveStaff(staffForm);

        return "redirect:/home";
    }
    
}
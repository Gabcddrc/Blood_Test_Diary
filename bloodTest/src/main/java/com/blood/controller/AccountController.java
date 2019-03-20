package com.blood.controller;

import com.blood.pojo.Staff;
import com.blood.service.StaffService;
import com.blood.service.MailService;
import com.blood.service.TestScheduleService;
import com.blood.validator.StaffValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class AccountController {

    @Autowired
    StaffService staffService;

    @Autowired
    MailService mailService;
    @Autowired
    TestScheduleService testScheduleService;
    StaffValidator staffValidator;

    @RequestMapping(value = "/login")
    public String getLogin(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        //mailService.sendNotification();
        testScheduleService.timeShif();
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("staff", new Staff());

        return "registers";
    }

    public static String encryption(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashed = passwordEncoder.encode(password);
        return hashed;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("staff") Staff staff, BindingResult bindingResult, Model model) {
        // staffValidator.validate(staff, bindingResult);
        Staff newStaff = new Staff(staff.getUsername(), staff.getForename(), staff.getSurname(), staff.getEmail(),
                encryption(staff.getPassword()));
        if (bindingResult.hasErrors()) {
            return "registers";
        }
        try {
            staffService.createStaff(newStaff);
        } catch (Exception e) {
            return "registers";
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    public String changePasswordForm(Model model){
        
        model.addAttribute("staff", new Staff());

        return "changePassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("staff") Staff staff, BindingResult bindingResult, Model model){
        Staff oldStaff =  staffService.getByUsername(staffService.getUser());
        oldStaff.setPassword(encryption(staff.getPassword()));
        System.out.println(oldStaff.getId());
        staffService.createStaff(oldStaff);
        return "redirect:/home";
    }
}

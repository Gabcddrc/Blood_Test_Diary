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

    StaffValidator staffValidator;


    @GetMapping("getUser")
    public Staff get(HttpSession session) throws Exception {
        Staff staff =(Staff)  session.getAttribute("staff");
        return staff;
    }

    @GetMapping(value="/login")
    public String getLogin() {
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

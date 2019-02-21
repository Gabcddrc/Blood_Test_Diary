package com.blood.controller;

import com.blood.pojo.Staff;
import com.blood.service.StaffService;
import com.blood.validator.StaffValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

   @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
       model.addAttribute("staff", new Staff());

       return "registers";
   }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("staff") Staff staff, BindingResult bindingResult, Model model) {
        //staffValidator.validate(staff, bindingResult);
        Staff newStaff = new Staff(staff.getUsername(),staff.getForename(),staff.getSurname(), staff.getEmail(),
          staff.getPassword());
        System.out.print(staff.getUsername());
        if (bindingResult.hasErrors()) {
            return "registers";
        }
        try{
        staffService.createStaff(newStaff);}
        catch(Exception e){
            return "registers";
        }

        return "redirect:/home";
    }
    
}
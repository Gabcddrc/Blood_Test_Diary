package com.blood.controller;

import com.blood.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value="/")
    public String index(){
        return "redirect:patients";
    }
   
    /*@GetMapping(value="/home")
    public String home(){
        return "/home";
    }*/

    @GetMapping(value="/registers")
    public String registers(){
        return "/registers";
    }

    /*@GetMapping(value="/AddPatient")
    public String addPattien(){
        return "/AddPatient";
    }*/

    @GetMapping(value="/email")
    public String email(){
        return "/email";
    }

   /* @GetMapping(value="/hospitals")
    public String hospitals(){
        return "/hospitals";
    }*/
    
    @GetMapping(value="/AddHospital")
    public String addhospitals(){
        return "/AddHospital";
    }

}

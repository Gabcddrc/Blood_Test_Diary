package com.blood.controller;

import com.blood.service.TestScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestScheduleController{
    @Autowired
    private TestScheduleService tScheduleService;

    
    @GetMapping("/home")
    public String getAllTestSchedule(Model model){
        model.addAttribute("testSchedules", this.tScheduleService.getAllTestSchedule());
        return "home";
    }

}
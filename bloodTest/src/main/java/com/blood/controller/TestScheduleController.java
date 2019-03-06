package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.pojo.TestSchedule;
import com.blood.service.PatientService;
import com.blood.service.TestScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestScheduleController{
    @Autowired
    private TestScheduleService tScheduleService;
    @Autowired
    private PatientService patientService;

    private static Patient patient; 
    
    @GetMapping("/home")
    public String getAllTestSchedule(Model model){
        model.addAttribute("testSchedules", this.tScheduleService.getAllTestSchedule());
        return "home";
    }

    @GetMapping("/email")
    public String getEmailTest(Model model){
        model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
        return "email";
    }

    @RequestMapping(value = "/editLabel", method = RequestMethod.POST)
    public String editLabel(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue,Model model) {
        if(checkboxValue[0] != null)
        {
         
          for (String var : checkboxValue) {
            System.out.println(var);
          }
        }
        else
        {
          System.out.println("checkbox is not checked");
        }
        return "redirect:/home";
    }



}
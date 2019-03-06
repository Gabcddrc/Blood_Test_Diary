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

    @RequestMapping(value = "/addTest/{id}", method = RequestMethod.GET)
    public String getAddTest(@PathVariable("id") String id, Model model){
        Patient patient = this.patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        model.addAttribute("test", new TestSchedule());
        
        return "addTest";
    }

    @RequestMapping(value="/addTest", method=RequestMethod.POST)
    public String addTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("test") TestSchedule test, BindingResult bindingResult,Model model) {
        TestSchedule newTest = new TestSchedule(test.getOPA(), test.getDate(), test.isCompleted(), test.getCommet(), test.isNotified(), test.getIdlabel());
        newTest.setPatient(patientService.findById(patient.getId()));
        // if (bindingResult.hasErrors()) {
        //     return "editPatients";
        // }
        try {
            tScheduleService.save(newTest);
        } catch (Exception e) {
            return "addTest";
        }
        return "redirect:/home";
    }
    




}
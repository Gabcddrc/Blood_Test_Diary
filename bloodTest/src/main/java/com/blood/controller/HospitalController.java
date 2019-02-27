package com.blood.controller;

import javax.servlet.http.HttpSession;

import com.blood.pojo.Hospital;
import com.blood.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Swapnil Paul
 */
@Controller
public class HospitalController {
    @Autowired
    HospitalService hospitalService; 

    @GetMapping("getHospital")
    public Hospital get(HttpSession session) throws Exception {
        Hospital hospital = (Hospital)  session.getAttribute("hospital");
        return hospital;
    }

    @GetMapping("/hospitals")
    public String getAllHospitals(Model model){
        model.addAttribute("hospitals", this.hospitalService.getAllHospital());
        return "hospitals";
    }

     @RequestMapping(value = "/AddHospital", method = RequestMethod.GET)
     public String registerForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "AddHospital";  
    }

     @RequestMapping(value = "/addHospital", method = RequestMethod.POST)
     public String saveRegister(@ModelAttribute("hospital") Hospital hospital, BindingResult bindingResult, Model model) {
        // hospitalValidator.validate(patient, bindingResult);
        Hospital newHospital = new  Hospital(hospital.getName(),hospital.getAddress(),hospital.getEmail(), hospital.getPhone());
        /* if (bindingResult.hasErrors()) {
             return "AddHospital";     
         }*/
         try{
             hospitalService.createHospital(newHospital);
         }
         catch(Exception e){
             return "AddHospital"; 
         }

         return "redirect:/home";
     }

}

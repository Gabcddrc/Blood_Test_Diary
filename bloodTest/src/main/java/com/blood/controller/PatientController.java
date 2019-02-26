package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PatientController {
    private PatientService patientService;
    @Autowired
    private MailService mailService;

    @Autowired
    public PatientController(PatientService patientService) {
        super();
        this.patientService = patientService;
        
    }

    @PostMapping("SendNotification")
    public void send() throws Exception {
        mailService.sendNotification(patientService.listNotificationPatients());
    }
    @PostMapping("SendResult")
    public Object sendResult(Patient patient,String file) throws Exception {
        boolean res = mailService.sendResult(patient,file);
        if (res==true){
            return 1;
        }
        else {
            return 0;
        }
    }

    @RequestMapping(value = "/AddPatient", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "AddPatient";
    }

    
    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model) {
        // patientValidator.validate(patient, bindingResult);
        Patient newPatient = new Patient(patient.getForename());
       /* if (bindingResult.hasErrors()) {
            return "AddPatient";
        }*/
        try {
            patientService.createPatient(newPatient); 
        } catch (Exception e) {
            return "AddPatient";
        }

        return "redirect:/home";
    }

}

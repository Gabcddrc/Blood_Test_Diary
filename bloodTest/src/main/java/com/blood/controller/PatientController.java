package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MailService mailService;
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

    @GetMapping
    public String getMethodName(Model model) {
        model.addAttribute("patients", this.patientService);
        return "patients";
    }
    

}

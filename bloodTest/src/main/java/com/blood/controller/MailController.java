package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MailService mailService;

    @PostMapping("SendNotification")
    public void send() throws Exception {
        mailService.sendNotification();
    }
    @PostMapping("sendDeleteEmail")
    public Object sendDelete(Patient patient)throws Exception{
        boolean res = mailService.sendDeleteResult(patient);
        if (res==true){
            return 1;
        }
        else {
            return 0;
        }
    }
    @PostMapping("SendResult")
    public Object sendResult(Patient patient, String file) throws Exception {
        boolean res = mailService.sendResult(patient,file);
        if (res==true){
            return 1;
        }
        else {
            return 0;
        }
    }
}

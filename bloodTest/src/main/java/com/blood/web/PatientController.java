package com.blood.web;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

}

package com.blood.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.mail.internet.MimeBodyPart;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MailController<StandardMultipartFile> {
    @Autowired
    private PatientService patientService;
    @Autowired
    private MailService mailService;

    @PostMapping("SendNotification")
    public void send() throws Exception {
        mailService.sendNotification();
    }

    @PostMapping("sendDeleteEmail")
    public Object sendDelete(Patient patient) throws Exception {
        boolean res = mailService.sendDeleteResult(patient);
        if (res == true) {
            return 1;
        } else {
            return 0;
        }
    }

    @PostMapping("SendResult")
    public Object sendResult(Patient patient, String file) throws Exception {
        boolean res = mailService.sendResult(patient, file);
        if (res == true) {
            return 1;
        } else {
            return 0;
        }
    }

    @GetMapping("/emailTesterr")
    public String getEmailTest(Model model) {
        // model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
        return "emailTesterr";
    }

    @RequestMapping(value = "/uploadPDF", method = RequestMethod.POST)
    public String editLabel(@RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        try {
            System.out.println("Upload PDF" + file.getName());
            System.out.println("Upload PDF" + file.getContentType());
            System.out.println("Upload PDF" + file.getResource());
            System.out.println("Upload PDF" + file.getOriginalFilename());
            // System.out.println("Upload PDF" +
            // file.getResource().getFile().getAbsolutePath());
            File fl = convert(file);
            System.out.println(fl.getAbsolutePath());
            mailService.sendResult(fl.getAbsolutePath());

        } catch (Exception e) {
            return "redirect:/emailTesterr";
        }
        return "redirect:/home";
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}

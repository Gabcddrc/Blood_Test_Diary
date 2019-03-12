package com.blood.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.MimeBodyPart;

import com.blood.pojo.Patient;
import com.blood.pojo.TestSchedule;
import com.blood.service.MailService;
import com.blood.service.PatientService;
import com.blood.service.TestScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MailController<StandardMultipartFile> {
    @Autowired
    private TestScheduleService tScheduleService;
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

    /*
     * @PostMapping("SendResult") public Object sendResult(Patient patient, String
     * file) throws Exception { boolean res = mailService.sendResult(patient, file);
     * if (res == true) { return 1; } else { return 0; } }
     */

    /**
     * Convert MultipartFile into File
     */
    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        String[] dateArr = dateString.split(" ");
        String[] dateArr2 = dateArr[1].split(":");
        dateString = dateArr[0] + "T" + dateArr2[0] + ":" + dateArr2[1];
        return dateString;
    }

    // Send Result (send attachment)
    @RequestMapping(value = "/sendTestResult/{id}", method = RequestMethod.GET)
    public String sendResultById(@PathVariable("id") String id, Model model) {
        TestSchedule testSchedule = this.tScheduleService.findById(Integer.parseInt(id));
        Patient patient = testSchedule.getPatient();
        patient.setDOB(dateToString(testSchedule.getDate()));
        model.addAttribute("test", testSchedule);
        model.addAttribute("patient", patient);

        return "sendTestResult";
    }

    @GetMapping("/sendTestResult")
    public String getResult(Model model) {
        // model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
        return "sendTestResult";
    }

    @RequestMapping(value = "/sendTestResult", method = RequestMethod.POST)
    public String editLabel(@RequestParam(value = "file", required = false) MultipartFile file,
            @ModelAttribute("patient") Patient patient, @ModelAttribute("test") TestSchedule test,
            BindingResult bindingResult, Model model) {
        try {
            System.out.println("Upload PDF" + file.getName());
            System.out.println("Upload PDF" + file.getContentType());
            System.out.println("Upload PDF" + file.getResource());
            System.out.println("Upload PDF" + file.getOriginalFilename());
            System.out.println(patient.getId() + " " + test.getId());
            // System.out.println("Upload PDF" +
            // file.getResource().getFile().getAbsolutePath());
            File fl = convert(file);
            System.out.println(fl.getAbsolutePath());
            mailService.sendResult(fl.getAbsolutePath(), patientService.findById(patient.getId()),
                    tScheduleService.findById(test.getId()));

        } catch (Exception e) {
            System.out.println("ERROR!!!!");
            return "redirect:/sendTestResult";
        }
        return "redirect:/home";
    }

    /**
     * @RequestMapping(value = "/sendTestResult", method = RequestMethod.POST)
     *                       public String sendResult(@ModelAttribute("patient")
     *                       Patient patient, @ModelAttribute("result") TestSchedule
     *                       result, BindingResult bindingResult, Model model)
     *                       throws ParseException {
     * 
     *                       Patient thePatient =
     *                       patientService.findById(patient.getId()); return
     *                       "redirect:/home"; }
     */

}

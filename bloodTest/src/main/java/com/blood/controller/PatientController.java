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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PatientController {
    @Autowired
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
        Patient newPatient = new Patient(patient.getForename(),patient.getSurname(),patient.getDOB(),patient.getSex(),patient.getAddress(),
                                        patient.getDiagnosis(),patient.getTransplant(),patient.getLocal_hospital(),patient.getSurgery(),patient.getComments());

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

    @RequestMapping(value = "/editPatient/{id}", method = RequestMethod.GET)
    public String getPatientsById(@PathVariable("id") String id, Model model) {
        Patient patient = this.patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        return "editPatients";
    }

    @RequestMapping(value = "/editPatient", method = RequestMethod.POST)
    public String saveEditPatient(@ModelAttribute("patient") Patient patient, BindingResult bindingResult,Model model) {
        Patient patient2 = new Patient();
        System.out.println(patient.getForename());
        patient2.setId(patient.getId());
        patient2.setForename(patient.getForename());
        patient2.setSurname(patient.getSurname());
        patient2.setAddress(patient.getAddress());
        patient2.setComments(patient.getComments());
        //patient2.setDOB(patient.getDOB()); //change this later 
        patient2.setEmail(patient.getEmail());
        patient2.setDiagnosis(patient.getDiagnosis());
        patient2.setLocal_hospital(patient.getLocal_hospital());
        patient2.setSex(patient.getSex());
        patient2.setSurgery(patient.getSurgery());
        patient2.setTransplant(patient.getTransplant());
        if (bindingResult.hasErrors()) {
            return "editPatients";
        }
        try {
            patientService.createPatient(patient2);
        } catch (Exception e) {
            return "editPatients";
        }
        return "redirect:/home";
    }

}

package com.blood.controller;

import com.blood.pojo.Patient;

import java.util.List;

import  com.blood.service.PatientService;
//import com.blood.service.ImportService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
/**
 * @Author Yilei Liang
 *
 * Patient DB Controller
 * RESTful Web Service
 */



@Controller
public class PatientDBController{
    @Autowired
    private PatientService patientService;

    //private ImportService importService;



    @RequestMapping(value = "/addPatientForm", method = RequestMethod.GET)
    public String addPatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "AddPatient";
    }


    @RequestMapping(value = "/deletePatient", method = RequestMethod.POST)
    public void delete(@ModelAttribute("patient") Patient patient){
        patientService.deletePatient(patient);
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String saveAdding(@ModelAttribute("patient") Patient patient, BindingResult bindingResult, Model model){
        try{
            patientService.add(patient);
        }
        catch (Exception e){
            return "AddPatient";
        }
        return "redirect:/home";
    }

    @GetMapping("/patients")
    public String getAllPatients(Model model){
        model.addAttribute("patients", this.patientService.getAllPatients());
        return "patients";
    }


    /**
     * Import the spreadsheet to DB
     */
    /**
    @RequestMapping(value = "/importSpreadsheet", method = RequestMethod.POST)
    public void importSpreadsheet(String fileLocation){
        importService.load(fileLocation);
    }
    */
    
}

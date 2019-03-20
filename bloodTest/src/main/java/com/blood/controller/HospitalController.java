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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("getHospital")
    public Hospital get(HttpSession session) throws Exception {
        Hospital hospital = (Hospital) session.getAttribute("hospital");
        return hospital;
    }

    @GetMapping("/hospitals")
    public String getAllHospitals(Model model) {
        model.addAttribute("hospitals", this.hospitalService.getAllHospital());
        return "hospitals";
    }

    @RequestMapping(value = "/AddHospital", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "AddHospital";
    }

    @RequestMapping(value = "/addHospital", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("hospital") Hospital hospital, BindingResult bindingResult,
            Model model) {
        // hospitalValidator.validate(hospital, bindingResult);
        Hospital newHospital = new Hospital(hospital.getName(), hospital.getAddress(), hospital.getEmail(),
                hospital.getPhone());
        /*
         * if (bindingResult.hasErrors()) { return "AddHospital"; }
         */
        try {
            hospitalService.createHospital(newHospital);
        } catch (Exception e) {
            return "AddHospital";
        }

        return "redirect:/hospitals";
    }





    @RequestMapping(value = "/editHospital/{id}", method = RequestMethod.GET)
    public String gethospitalsById(@PathVariable("id") String id, Model model) {
        Hospital hospital = this.hospitalService.findById(Integer.parseInt(id));
        model.addAttribute("hospital", hospital);
        return "editHospitals";
    }

    @RequestMapping(value = "/editHospital", method = RequestMethod.POST)
    public String saveEdithospital(@ModelAttribute("hospital") Hospital hospital, BindingResult bindingResult,
            Model model) {
        Hospital hospital2 = new Hospital();
        hospital2.setId(hospital.getId());
        hospital2.setName(hospital.getName());
        hospital2.setAddress(hospital.getAddress());
        hospital2.setEmail(hospital.getEmail());
        hospital2.setPhone(hospital.getPhone());

        if (bindingResult.hasErrors()) {
            return "editHospitals";
        }
        try {
            hospitalService.createHospital(hospital2);
        } catch (Exception e) {
            return "editHospitals";
        }
        return "redirect:/hospitals";
    }
    @RequestMapping(value = "editHospital/deleteHospital/{id}", method = RequestMethod.GET)
    public String deleteHospital(@PathVariable("id") String id){
        try{
            hospitalService.deleteHospital(Integer.parseInt(id));
        } catch (Exception e){
            return "editHospital";
        }

        return "redirect:/hospitals";
    }

}

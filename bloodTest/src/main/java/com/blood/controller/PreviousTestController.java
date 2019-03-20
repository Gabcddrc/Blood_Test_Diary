package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
import com.blood.service.PreviousTestService;

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
public class PreviousTestController {
    @Autowired
    private PreviousTestService previousTestService;

    @Autowired
    public PreviousTestController(PreviousTestService previousTestService) {
        super();
        this.previousTestService = previousTestService;
    }

    @GetMapping("/previousTests")
    public String getAllTestSchedule(Model model) {
        model.addAttribute("previousTests", this.previousTestService.getAllPreviousTest());
        return "previousTests";
    }

}

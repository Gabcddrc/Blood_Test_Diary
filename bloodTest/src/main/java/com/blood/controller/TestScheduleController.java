package com.blood.controller;

import com.blood.pojo.Patient;
import com.blood.pojo.TestSchedule;
import com.blood.service.PatientService;
import com.blood.service.TestScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestScheduleController {
  @Autowired
  private TestScheduleService tScheduleService;
  @Autowired
  private PatientService patientService;

    @RequestMapping(value = "/addTest/{id}", method = RequestMethod.GET)
    public String getAddTest(@PathVariable("id") String id, Model model){
        Patient patient = this.patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        model.addAttribute("test", new TestSchedule());
        
        return "addTest";
    }

    @RequestMapping(value="/addTest", method=RequestMethod.POST)
    public String addTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("test") TestSchedule test, BindingResult bindingResult,Model model) {
        TestSchedule newTest = new TestSchedule(test.getOPA(), test.getDate(), test.isCompleted(), test.getCommet(), test.isNotified(), test.getIdlabel());
        newTest.setPatient(patientService.findById(patient.getId()));
        // if (bindingResult.hasErrors()) {
        //     return "editPatients";
        // }
        try {
            tScheduleService.save(newTest);
        } catch (Exception e) {
            return "addTest";
        }
        return "redirect:/home";
    }
    



  private static Patient patient;

  private final String COLOR_RED = "badge red";
  private final String COLOR_GREEN = "badge green";
  private final String COLOR_ORANGE = "badge orange";
  private final String URGENT = "Mark Urgent";
  private final String MONITOR = "Mark Monitor";
  private final String CRITICAL = "Mark Critical";

  @GetMapping("/home")
  public String getAllTestSchedule(Model model) {
    model.addAttribute("testSchedules", this.tScheduleService.getAllTestSchedule());
    return "home";
  }

  @GetMapping("/email")
  public String getEmailTest(Model model) {
    model.addAttribute("tests", this.tScheduleService.getAllTestSchedule());
    return "email";
  }

  @RequestMapping(value = "/editLabel", method = RequestMethod.POST)
  public String editLabel(@RequestParam(value = "checkboxName", required = false) String[] checkboxValue,
      @RequestParam(value = "submitBtn", required = false) String submitBtn, Model model) {
        try {
          if(submitBtn.equals(URGENT) && checkboxValue.length>0){
            for (String id : checkboxValue) {
              TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
              ts.setIdlabel(COLOR_ORANGE);
              tScheduleService.updateLabel(ts);
            }
          }else if(submitBtn.equals(MONITOR) && checkboxValue.length>0){
            for (String id : checkboxValue) {
              TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
              ts.setIdlabel(COLOR_GREEN);
              tScheduleService.updateLabel(ts);
            }
          }else if(submitBtn.equals(CRITICAL) && checkboxValue.length>0){
            for (String id : checkboxValue) {
              TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
              ts.setIdlabel(COLOR_RED);
              tScheduleService.updateLabel(ts);
            }
          }
          
      } catch (Exception e) {
          return "redirect:/home";
      }
   
   
    return "redirect:/home";
  }

}
package com.blood.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestScheduleController {
  @Autowired
  private TestScheduleService tScheduleService;
  @Autowired
  private PatientService patientService;

  @Autowired
  private MailService mailService;

  @RequestMapping(value = "/addTest/{id}", method = RequestMethod.GET)
  public String getAddTest(@PathVariable("id") String id, Model model) {
    Patient patient = this.patientService.findById(Integer.parseInt(id));
    model.addAttribute("patient", patient);
    model.addAttribute("test", new TestSchedule());

    return "addTest";
  }

  public String dateToString(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(date);
    String[] dateArr = dateString.split(" ");
    String[] dateArr2 = dateArr[1].split(":");
    dateString = dateArr[0] + "T" + dateArr2[0] + ":" + dateArr2[1];
    return dateString;
  }

  @RequestMapping(value = "/editTest/{id}", method = RequestMethod.GET)
  public String getTestsById(@PathVariable("id") String id, Model model) {
    TestSchedule testSchedule = this.tScheduleService.findById(Integer.parseInt(id));
    Patient patient = testSchedule.getPatient();
    patient.setDOB(dateToString(testSchedule.getDate()));
    model.addAttribute("testEdit", testSchedule);
    model.addAttribute("patient", patient);

    return "editTest";
  }

  @RequestMapping(value = "/editTest", method = RequestMethod.POST)
  public String editTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("testEdit") TestSchedule test,
      BindingResult bindingResult, Model model) throws ParseException {
    Patient thePatient = patientService.findById(patient.getId());

    TestSchedule newTest = new TestSchedule(test.getOPA(), formatDate(patient.getDOB()), test.isCompleted(),
        test.getCommet(), test.isNotified(), test.getIdlabel(), test.getMissTest());
    newTest.setPatient(thePatient);
    newTest.setId(test.getId());
    // if (tScheduleService.findByPatient(thePatient) != null) {
    // newTest.setId(tScheduleService.findByPatient(thePatient).getId());
    // }
    // if (bindingResult.hasErrors()) {
    // return "editPatients";
    // }
    try {
      tScheduleService.save(newTest);
    } catch (Exception e) {
      return "editTest";
    }
    return "redirect:/home";
  }

  @RequestMapping(value = "editTest/deleteTest/{id}", method = RequestMethod.GET)
  public String deletePatient(@PathVariable("id") String id){
      try{
          tScheduleService.deleteTest(Integer.parseInt(id));
      } catch (Exception e){
          return "editTest";
      }

      return "redirect:/home";
  }


  public Date formatDate(String date) throws ParseException {
    String[] dates = date.split("T");
    date = dates[0] + " " + dates[1] + ":00";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date datetime = formatter.parse(date);
    return datetime;
  }

  @RequestMapping(value = "/addTest", method = RequestMethod.POST)
  public String addTest(@ModelAttribute("patient") Patient patient, @ModelAttribute("test") TestSchedule test,
      BindingResult bindingResult, Model model) throws ParseException {

    Patient thePatient = patientService.findById(patient.getId());

    TestSchedule newTest = new TestSchedule(test.getOPA(), formatDate(patient.getDOB()), test.isCompleted(),
        test.getCommet(), test.isNotified(), test.getIdlabel(), 0);
    newTest.setPatient(thePatient);
    // if (tScheduleService.findByPatient(thePatient) != null) {
    // newTest.setId(tScheduleService.findByPatient(thePatient).getId());
    // }
    // if (bindingResult.hasErrors()) {
    // return "editPatients";
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
  private final String COLOR_WHITE = "badge white";
  private final String URGENT = "Mark Urgent";
  private final String MONITOR = "Mark Monitor";
  private final String CRITICAL = "Mark Critical";
  private final String OPA = "Mark OPA";

  @GetMapping("/home")
  public String getAllTestSchedule(Model model) {
    model.addAttribute("testSchedules", this.tScheduleService.getAllTestSchedule());
    model.addAttribute("testEdit", new TestSchedule());
    tScheduleService.timeShif();
    // mailService.sendNotification(); // <-- TO BE ENABLE (when you enable say to
    // the group)
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
      if (submitBtn.equals(URGENT) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_ORANGE);
          tScheduleService.updateLabel(ts);
        }
      } else if (submitBtn.equals(MONITOR) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_GREEN);
          tScheduleService.updateLabel(ts);
        }
      } else if (submitBtn.equals(CRITICAL) && checkboxValue.length > 0) {
        for (String id : checkboxValue) {
          TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
          ts.setIdlabel(COLOR_RED);
          tScheduleService.updateLabel(ts);
        }
      }
        else if (submitBtn.equals(OPA) && checkboxValue.length > 0) {
          for (String id : checkboxValue) {
            TestSchedule ts = this.tScheduleService.findById(Integer.parseInt(id));
            ts.setIdlabel(COLOR_WHITE);
            tScheduleService.updateLabel(ts);
          }
      }

    } catch (Exception e) {
      return "redirect:/home";
    }

    return "redirect:/home";
  }

}
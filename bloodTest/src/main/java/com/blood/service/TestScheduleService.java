package com.blood.service;

import java.util.ArrayList;
import java.util.List;

import com.blood.dao.TestScheduleDAO;
import com.blood.pojo.TestSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TestScheduleService {
    @Autowired
    TestScheduleDAO testScheduleDAO;

    public TestSchedule findById(int id) {
        return testScheduleDAO.findById(id);
    }

  /*  public TestSchedule findByIdPatient(int idpatient) {
        return testScheduleDAO.findByIdPatient(idpatient);
    }

    public TestSchedule findByIdLabel(int idlabel) {
        return testScheduleDAO.findByIdLabel(idlabel);
    }
  */
    public TestSchedule findByCompleted(boolean complete) {
        return testScheduleDAO.findByCompleted(complete);
    }

    public void add(TestSchedule testSchedule) {
        testScheduleDAO.save(testSchedule);
    }

    public void deletePatient(int id) {
        testScheduleDAO.delete(testScheduleDAO.findById(id));
    }

    public List<TestSchedule> getAllTestSchedule() {
        List<TestSchedule> testSchedule = new ArrayList<>();
        this.testScheduleDAO.findAll().forEach(testSchedule::add);
        return testSchedule;
    }

    public void updateTestSchedule(TestSchedule tSchedule, int id, String OPA, Date date, boolean completed,
    String commet, boolean notified, int idpatient, String idlabel) {
                tSchedule.setId(id);
                tSchedule.setOPA(OPA);
                tSchedule.setDate(date);
                tSchedule.setCompleted(completed);
                tSchedule.setCommet(commet);
                tSchedule.setNotified(notified);
                // tSchedule.setIdpatient(idpatient);
                tSchedule.setIdlabel(idlabel);
                testScheduleDAO.save(tSchedule);
        // TODO:REST
    }

    
    public List<TestSchedule> findAll() {
        return testScheduleDAO.findAll();
    }

}
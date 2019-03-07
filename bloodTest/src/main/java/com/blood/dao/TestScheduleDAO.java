package com.blood.dao;

import com.blood.pojo.TestSchedule;
import com.blood.pojo.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Swapnil
 * Date: 21/02/2019
 */

@Repository
public interface TestScheduleDAO extends JpaRepository<TestSchedule, Integer>{
    TestSchedule findById(int id);
   // TestSchedule findByOPA(String OPA);
    TestSchedule findByDate(String date);
    TestSchedule findByCompleted(boolean completed);
    TestSchedule findByPatient(Patient patient);
  //  TestSchedule findByIdLabel(int idlabel);
}
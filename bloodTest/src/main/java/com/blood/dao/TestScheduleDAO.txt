package com.blood.dao;

import com.blood.pojo.TestSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Swapnil
 * Date: 21/02/2019
 */

@Repository
public interface TestScheduleDAO extends JpaRepository<TestSchedule, Long>{
    TestSchedule findById(int id);
    TestSchedule findByOPA(String OPA);
    TestSchedule findByDate(String date);
    TestSchedule findByCompleted(boolean complete);
    TestSchedule findByPatient(int idPatient);
    TestSchedule findByLabel(int idLabel);
}
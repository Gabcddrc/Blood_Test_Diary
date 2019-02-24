package com.blood.dao;

import com.blood.pojo.TestCarriedOver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Swapnil
 * Date: 21/02/2019
 */

@Repository
public interface TestCarriedOverDAO extends JpaRepository<TestCarriedOver, Long>{
    TestCarriedOver findById(int id);
    TestCarriedOver findByOPA(String OPA);
    TestCarriedOver findByDate(String date);
    TestCarriedOver findByCompleted(boolean complete);
    TestCarriedOver findByPatient(int idPatient);
    TestCarriedOver findByLabel(int idLabel);
}
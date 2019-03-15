package com.blood.service;

import java.util.*;

import com.blood.dao.PreviousTestDAO;
import com.blood.pojo.PreviousTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreviousTestService {
    @Autowired
    PreviousTestDAO previousTestDAO;

    public PreviousTest findById(int id) {
        return previousTestDAO.findById(id);
    }

    public PreviousTest save(PreviousTest previousTest) {
        previousTestDAO.save(previousTest);
        return previousTest;
    }

    public List<PreviousTest> getAllPreviousTest() {
        List<PreviousTest> previousTest = new ArrayList<>();
        this.previousTestDAO.findAll().forEach(previousTest::add);
        return previousTest;
    }

    public List<PreviousTest> findAll() {
        return previousTestDAO.findAll();
    }

}
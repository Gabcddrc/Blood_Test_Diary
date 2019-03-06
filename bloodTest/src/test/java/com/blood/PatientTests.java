package com.blood;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import com.blood.pojo.Patient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class PatientTests {
    

    @Test
    public void testGetForename() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        assertEquals(patient.getForename(), "tForename");
    }

    @Test
    public void testSetForename() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        patient.setForename("changedName");

        assertEquals(patient.getForename(), "changedName");
    }

    @Test
    public void testGetSurname() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        assertEquals(patient.getSurname(), "tSurname");
    }

    @Test
    public void testSetSurename() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        patient.setSurname("changedName");

        assertEquals(patient.getSurname(), "changedName");
    }

    @Test
    public void testGetEmail() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        assertEquals(patient.getEmail(), "tEmail");
    }

    @Test
    public void testSetEmail() {
        
        Patient patient = new Patient("tForename", "tSurname", "tEmail");

        patient.setEmail("changedEmail");

        assertEquals(patient.getEmail(), "changedEmail");
    }

}
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

    @Test
    public void testGetSurgery() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        
        assertEquals(patient.getSurgery(), "tSurgery");
    }

    @Test
    public void testSetSurgery() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        patient.setSurgery("changedSurgery");
        assertEquals(patient.getSurgery(), "changedSurgery");
    }

    @Test
    public void testGetComments() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        
        assertEquals(patient.getComments(), "tComments");
    }

    @Test
    public void testSetComments() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        patient.setComments("changedComments");
        assertEquals(patient.getComments(), "changedComments");
    }

    @Test
    public void testgetDiagnosis() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
       "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        
        assertEquals(patient.getDiagnosis(), "tDiagnosis");
    }

    @Test
    public void testSetDiagnosis() {
        
        Patient patient = new Patient("tForename", "tSurname", "1997-03-03", 'M', "Great Britannia Street","tDiagnosis",
        "tTransplant", "tlocal_hospital", "tSurgery", "tComments");
        patient.setDiagnosis("changedDiagnosis");
        assertEquals(patient.getDiagnosis(), "changedDiagnosis");
    }

    @Test
    public void testEmptyDetails() {   
        Patient patient = new Patient();
        assertEquals(patient.getEmail(), null);
        assertEquals(patient.getSurname(), null);
        assertEquals(patient.getForename(), null);
        assertEquals(patient.getSurgery(), null);
        assertEquals(patient.getComments(), null);
        assertEquals(patient.getDiagnosis(), null);
    }
    

}
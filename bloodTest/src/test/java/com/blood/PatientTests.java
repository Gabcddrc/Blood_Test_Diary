package com.blood;

import static org.assertj.core.api.Assertions.*;

import com.blood.dao.PatientDAO;
import com.blood.pojo.Patient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientTests {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientDAO patientDAO;

    @Test
    public void whenFindByEmail_thenReturnPatient() {
        
        // given
        Patient testPatient = new Patient("tForename", "tSurname", "tDOB", 'M', "tAddress", "tDiagnosis", "tTransplant", "tHospital", "tSurgery", "tComments");
        entityManager.persist(testPatient);
        entityManager.flush();
 
        // when
        Patient foundPatient = patientDAO.findByEmail(testPatient.getEmail());
 
        // then
        assertThat(foundPatient.getEmail()).isEqualTo(testPatient.getEmail());
    }

}
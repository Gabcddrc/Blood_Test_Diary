package com.blood.service;

import com.blood.dao.PatientDAO;
import com.blood.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientDAO patientDAO;
    public Patient findByEmail(String email){return patientDAO.findByEmail(email);}
    public void add(Patient patient){patientDAO.save(patient);}
    public void deletePatient(int id){patientDAO.delete(patientDAO.findById(id));}
    public List<Patient> listNotificationPatients(){
        List<Patient> patients = patientDAO.findAll();
        List<Patient> patients1 = new ArrayList<Patient>();
        for (Patient patient:patients){
            if(patient.getOverTime()==true){
                patients1.add(patient);
            }
        }
        return patients1;
    }
}

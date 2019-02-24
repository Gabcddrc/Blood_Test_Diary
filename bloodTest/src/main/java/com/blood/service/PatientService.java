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
        // for (Patient patient:patients){
        //     if(patient.getOverTime()==true){
        //         patients1.add(patient);
        //     }
        // }
        return patients1;
    }

    /*
    retrive all patient
    */
    public List<Patient> getAllPatients(){
        List <Patient> patients = new ArrayList<>();
        this.patientDAO.findAll().forEach(patients::add);
        return patients;
    }



    public void updatePatient(Patient patient, int id, String forename, String surname, String DOB,
        String email, char sex, String address, String diagnosis, String transplant, String local_hospital,
                              String surgery, String comments, Boolean overTime){
        patient.setId(id);
        patient.setForename(forename);
        patient.setSurname(surname);
        patient.setDOB(DOB);
        patient.setEmail(email);
        patient.setSex(sex);
        patient.setAddress(address);
        patient.setDiagnosis(diagnosis);
        patient.setTransplant(transplant);
        patient.setLocal_hospital(local_hospital);
        patient.setSurgery(surgery);
        patient.setComments(comments);
        //patient.setOverTime(overTime);
        patientDAO.save(patient);
        //TODO:REST
    }

    public void deletePatient(Patient patient){
        patientDAO.delete(patient);
    }

    public List<Patient> findAll(){
        return patientDAO.findAll();
    }

    public List<Patient> findBySurname(String keyWord){
        List<Patient> patients = patientDAO.findAll();
        List<Patient> res = new ArrayList<Patient>();
        for (Patient patient:patients){
            if (patient.getSurname().equals(keyWord)){
                res.add(patient);
            }
        }
        return res;

    }

    public List<Patient> findByForename(String keyWord){
        List<Patient> patients = patientDAO.findAll();
        List<Patient> res = new ArrayList<Patient>();
        for (Patient patient:patients){
            if (patient.getForename().equals(keyWord)){
                res.add(patient);
            }
        }
      return res;
    }
    

}

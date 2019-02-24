package com.blood.service;

import com.blood.dao.HospitalDAO;
import com.blood.pojo.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Swapnil Paul
 */
@Service
public class HospitalService {
    @Autowired
    HospitalDAO hospitalDAO;

    public void saveHospital(Hospital hospital) {
        hospitalDAO.save(hospital);
    }

    public Hospital getByIdhospital(int idhospital) {
        return hospitalDAO.findByIdhospital(idhospital);
    }

    public Hospital getByName(String name) {
        return hospitalDAO.findByName(name);
    }

    public Hospital getByPhone(String phone) {
        return hospitalDAO.findByPhone(phone);
    }

    public Hospital getByAddress(String address) {
        return hospitalDAO.findByAddress(address);
    }

    public Hospital getByEmail(String email) {
        return hospitalDAO.findByEmail(email);
    }
    
    public Hospital createHospital(Hospital hospital){
         hospitalDAO.save(hospital);
         return hospital;
    }

    public void changeName(Hospital hospital, String name) {
        hospital.setName(name);
        hospitalDAO.save(hospital);
    }

    public void changePhone(Hospital hospital, String phone) {
        hospital.setName(phone);
        hospitalDAO.save(hospital);
    }

    public void changeAddress(Hospital hospital, String address) {
        hospital.setName(address);
        hospitalDAO.save(hospital);
    }

    public void changeEmail(Hospital hospital, String email) {
        hospital.setName(email);
        hospitalDAO.save(hospital);
    }
}

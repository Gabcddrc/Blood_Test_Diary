package com.blood.service;

import com.blood.dao.HospitalDAO;
import com.blood.pojo.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    HospitalDAO hospitalDAO;

    public void saveHospital(Hospital hospital){
        hospitalDAO.save(hospital);
    }

    public Hospital getById(int id) {
        return hospitalDAO.findById(id);
    }
     
    public Hospital getByName(String name){
        return hospitalDAO.findByName(name);
    }

    public Hospital getByPhone(String phone){
        return hospitalDAO.findByPhone(phone);
    }

    public Hospital getByAddress(String address){
        return hospitalDAO.findByAddress(address);
    }
    public Hospital getByEmail(String email){
        return hospitalDAO.findByEmail(email);
    }

}

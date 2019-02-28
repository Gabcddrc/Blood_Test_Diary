package com.blood.service;

import java.util.List;
import java.util.ArrayList;

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

    public Hospital getById(int id) {
        return hospitalDAO.findById(id);
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
    public Hospital findById(int id) {
        return hospitalDAO.findById(id);
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

    public Hospital createHospital(Hospital hospital) {
        hospitalDAO.save(hospital);
        return hospital;
    }

    public void deleteHospital(int id) {
        hospitalDAO.delete(hospitalDAO.findById(id));
    }

    public List<Hospital> getAllHospital() {
        List<Hospital> hospital = new ArrayList<>();
        this.hospitalDAO.findAll().forEach(hospital::add);
        return hospital;
    }

    public void updateHospital(Hospital hospital, int id, String name, String email,
    String address, String phone) {
                hospital.setId(id);
                hospital.setName(name);
                hospital.setEmail(email);
                hospital.setAddress(address);
                hospital.setPhone(phone);
                hospitalDAO.save(hospital);
        // TODO:REST
    }

    
    public List<Hospital> findAll() {
        return hospitalDAO.findAll();
    }

}

package com.blood.dao;

import com.blood.pojo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDAO extends JpaRepository<Patient,Integer>{
        Patient findByUsername(String username);
        Patient findByEmail(String email);
        Patient findById(int id);
}

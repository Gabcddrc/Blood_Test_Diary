package com.blood.dao;

import com.blood.pojo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends JpaRepository<Patient,Long>{
        //Patient findByUsername(String username);
        Patient findByEmail(String email);
        Patient findById(int id);
}

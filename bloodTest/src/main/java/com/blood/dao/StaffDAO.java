package com.blood.dao;

import com.blood.pojo.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDAO extends JpaRepository<Staff, Long>{
    Staff findByUsername(String username);
    Staff findById(int id);
}

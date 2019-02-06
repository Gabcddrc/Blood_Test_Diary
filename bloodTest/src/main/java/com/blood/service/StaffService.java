package com.blood.service;


import com.blood.dao.StaffDAO;
import com.blood.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    StaffDAO staffDAO;

    private BCryptPasswordEncoder encoder;

    public void saveStaff(Staff staff){
        staff.setPassword(encoder.encode(staff.getPassword()));
        staffDAO.save(staff);
    }

    public Staff getById(int id){return staffDAO.findById(id);}
    public Staff getByUsername(String username) {
        return staffDAO.findByUsername(username);
    }

}

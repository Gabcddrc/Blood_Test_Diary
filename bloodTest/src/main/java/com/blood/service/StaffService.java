package com.blood.service;


import com.blood.dao.StaffDAO;
import com.blood.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    StaffDAO staffDAO;

    public Staff getById(int id){return staffDAO.findById(id);}
    public Staff getByName(String username) {
        return staffDAO.findByUsername(username);
    }

}

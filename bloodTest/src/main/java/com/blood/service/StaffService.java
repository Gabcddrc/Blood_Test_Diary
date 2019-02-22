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

    /*
     * Encode password
     */
    public void saveStaff(Staff staff) {
        staff.setPassword(encoder.encode(staff.getPassword()));
        staffDAO.save(staff);
    }

    /*
     * change password
     */
    public void changePassword(Staff staff, String password) {
        staff.setPassword(encoder.encode(password));
        staffDAO.save(staff);
    }

    /*
     * change username
     */
    public void changeUsername(Staff staff, String username) {
        staff.setUsername(username);
        staffDAO.save(staff);
    }

    public Staff getById(int id) {
        return staffDAO.findById(id);
    }

    public Staff getByUsername(String username) {
        return staffDAO.findByUsername(username);
    }

    public Staff createStaff(Staff staff){
        //  Staff newStaff = new Staff(staff.getUsername(),staff.getForename(),staff.getSurname(), staff.getEmail(),
        //   encoder.encode(staff.getPassword()), encoder.encode(staff.getConfirmPassword()));
         staffDAO.save(staff);
         return staff;
     }
}

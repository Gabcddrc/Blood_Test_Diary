package com.blood.service;

import com.blood.dao.StaffDAO;
import com.blood.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

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

    public String getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.print(currentUserName);
            return currentUserName;
        }
        return " ";
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

    public Staff createStaff(Staff staff) {
        staffDAO.save(staff);
        return staff;
    }

    /*
     * data display template
     */
    public List<Staff> getAllStaff() {
        List<Staff> staffs = new ArrayList<>();
        this.staffDAO.findAll().forEach(staffs::add);
        return staffs;
    }
}

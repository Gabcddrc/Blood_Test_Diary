package com.blood.service;

import com.blood.pojo.Hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class HospitalDBService{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Hospital> getAllHospital(){
        String sql = "SELECT * FROM Hospital";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        List<Hospital> hospitalLists =new ArrayList<>();
        for (Map<String,Object> map:list){
            Hospital hospital = new Hospital();
            hospital.setId(Integer.parseInt((String) map.get("idhospital")));
            hospital.setName(map.get("name").toString());
            hospital.setAddress(map.get("address").toString());
            hospital.setEmail(map.get("email").toString());
            hospital.setPhone(map.get("phone").toString());
            hospitalLists.add(hospital);
        }
        return hospitalLists;
    }

    public List<Hospital> searchByName(String name){
        String sql = "SELECT * FROM Hospital where name like %"+name+"%";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        List<Hospital> hospitalLists =new ArrayList<>();
        for (Map<String,Object> map:list){
            Hospital hospital = new Hospital();
            hospital.setId(Integer.parseInt((String) map.get("idhospital"))); 
            hospital.setName(map.get("name").toString());
            hospital.setAddress(map.get("address").toString());
            hospital.setEmail(map.get("email").toString());
            hospital.setPhone(map.get("phone").toString());
            hospitalLists.add(hospital);
        }
        return hospitalLists;
    }


    public void updateHospitalInfo(Hospital hospital){
        //TODO: Code goes here
    }

    public void add(Hospital hospital){
        //TODO: Code goes here
    }

    public void delete(Hospital hospital){
        //TODO: Code goes here
    }
}
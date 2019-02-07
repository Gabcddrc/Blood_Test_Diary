package com.blood.dao.impl;

import com.blood.dao.QueryPatientDao;
import com.blood.pojo.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class patientDaoImpl implements QueryPatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Patient> findExpired() {
		String sql = "SELECT email from Patients where overTime==True" // Depends on the unit (days or weeks)
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Patient.class));
	}

	@Override
	public Patient update(Patient patient){
		//Code goes here
	}

	@Override
	public Patient delete(Paitent patient) {
		//Code goes here
	}

	@Override
	public Patient add(Patient patient){
		//Code goes here
	}

}

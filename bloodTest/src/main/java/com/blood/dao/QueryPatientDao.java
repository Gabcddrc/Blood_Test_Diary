package com.blood.dao;

import com.blood.pojo.Patient;

import java.util.List;


public interface QueryPatientDao{
	
	/**
	 * Find all expired patients
	 */
	List<Patient> findExpired();
}
package com.blood.dao;

import com.blood.pojo.Patient;

import java.util.List;


public interface QueryPatientDao{
	
	/**
	 * Find all expired patients
	 */
	List<Patient> findExpired();
	
	/**
	 * Update the information of the patient
	 */
	Patient update(Patient patient);

	/**
	 * Delete the patient
	 */
	Patient delete(Patient patient);
	
	
	/**
	 * Add new patient
	 */
	Patient add(Patient patient)
	 
	/**
	 * Find all patients records
	 */
	
	List<Patient> findAllPatients();
	
}
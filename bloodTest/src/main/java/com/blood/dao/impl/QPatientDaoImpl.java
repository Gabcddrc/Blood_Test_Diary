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

//This Class might refactor to Service
//ALL SQL FUNCTIONS NEED TO BE UPDATED WHEN DB IS BUILT
//Can be refactored due to duplicated codes

/**
 * @Author Yilei Liang
 *
 * Note: A potential design is that the web page passed the parameter and just call
 * the method here, the methods here will return the data to be displayed on the Page
 *
 * TO DO: Refactor the SQL commands to fulfill the DB
 *
 * As lots of code are duplicated here, they need to be refactored
 */

public class QPatientDaoImpl implements QueryPatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Patient> findExpired() {
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients where overTime=True");
		List<Patient> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("idpatient").toString());
			patient.setEmail(map.get("email").toString());
			patient.setDOB(map.get("DOB").toString());
			patient.setSex(map.get("sex").toString());
			patient.setAddress(map.get("address").toString());
			patient.setDiagnosis(map.get("diagnosis").toString());
			patient.setTrasplant(map.get("trasplant").toString());
			patient.setLocal_hospital(map.get("local_hospital").toString());
			patient.setSurgery(map.get("surgery").toString());
			patient.setCommets(map.get("commets").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("overtime"))); //As OT is a bool
			patient.setForeName(map.get("forename").toString());
			patient.setSurName(map.get("surname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}

	@Override
	public Patient update(Patient patient){
		//This function need to be considered again as what to update is unknown
		String sql = "UPDATE Patient SET " +
				"email = ? , overTime = ?"+
				"forename = ?, surname = ?"+
				"DOB = ? , sex = ?"+
				"address = ?, diagnosis = ?"+
				"trasplant = ?, local_hospital = ?"+
				"surgery = ? , commets = ?"+
				"where idpatient = ?";
		Object[] args = {patient.getEmail(), patient.getOverTime(),
					patient.getForeName(), patient.getSurName(),
					patient.getDOB(), patient.getSex(),
					patient.getAddress(), patient.getDiagnosis(),
					patient.getTrasplant(), patient.getLocal_hospial(),
					patient.getSurgery(), patient.getCommets()};
		int[] types = {Types.VARCHAR, Types.BOOLEAN, Types.VARCHAR, Types.VARCHAR
		Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,};
		int rows = jdbcTemplate.update(sql,args,types);
		return (rows==1); //True when the patient is updated successfully
	}

	@Override
	public boolean delete(Paitent patient) {
		String sql = "DELETE FROM Patient where idpatient=?";
		Object[] args = { patient.getId() };
		int[] types = {Types.VARCHAR};
		int rows = jdbcTemplate.update(sql,args,types);
		return (rows==1); //True if the patient is deleted successfully
	}

	@Override
	public void add(Patient patient){
		String sql = "insert into Patient(idpatient, forename, surname, DOB, email" +
				"sex, address, diagnosis, trasplant, local_hospital, surgery, commets, overtime)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{
				patient.getId();
				patient.getForename();
				patient.getSurname();
				patient.getDOB();
				patient.getEmail();
				patient.getSex();
				patient.getAddress();
				patient.getDiagnosis();
				patient.getTrasplant();
				patient.getLocal_hospial();
				patient.getSurgery();
				patient.getCommets();
				patient.getOvertime();
				}, new int[]{Types.VARCHAR,Types.VARCHAR,
					Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.BOOLEAN});

	}

	@Override
	public List<Patient> findAllPatients(){
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients");
		List<CusBaseInfo> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("idpatient").toString());
			patient.setEmail(map.get("email").toString());
			patient.setDOB(map.get("DOB").toString());
			patient.setSex(map.get("sex").toString());
			patient.setAddress(map.get("address").toString());
			patient.setDiagnosis(map.get("diagnosis").toString());
			patient.setTrasplant(map.get("trasplant").toString());
			patient.setLocal_hospital(map.get("local_hospital").toString());
			patient.setSurgery(map.get("surgery").toString());
			patient.setCommets(map.get("commets").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("overtime"))); //As OT is a bool
			patient.setForeName(map.get("forename").toString());
			patient.setSurName(map.get("surname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}


	@Override
	public List<Patient> findByForename(String keyWord){
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients where forename like %"+keyWord+"%");
		List<CusBaseInfo> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("idpatient").toString());
			patient.setEmail(map.get("email").toString());
			patient.setDOB(map.get("DOB").toString());
			patient.setSex(map.get("sex").toString());
			patient.setAddress(map.get("address").toString());
			patient.setDiagnosis(map.get("diagnosis").toString());
			patient.setTrasplant(map.get("trasplant").toString());
			patient.setLocal_hospital(map.get("local_hospital").toString());
			patient.setSurgery(map.get("surgery").toString());
			patient.setCommets(map.get("commets").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("overtime"))); //As OT is a bool
			patient.setForeName(map.get("forename").toString());
			patient.setSurName(map.get("surname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}



}
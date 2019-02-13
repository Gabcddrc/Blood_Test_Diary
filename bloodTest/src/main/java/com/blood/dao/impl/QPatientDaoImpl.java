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
public class patientDaoImpl implements QueryPatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public List<Patient> findExpired() {
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients where Overtime=True");
		List<CusBaseInfo> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("Id").toString());
			patient.setEmail(map.get("Email").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("Overtime"))); //As OT is a bool
			patient.setFirstName(map.get("Firstname").toString());
			patient.setLastName(map.get("Lastname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}

	@Override
	public Patient update(Patient patient){
		//This function need to be considered again as what to update is unknown
		String sql = "UPDATE Patient SET " +
				"Email = ? , Overtime = ?"+
				"Firstname = ?, Lastname = ?"+
				"where id = ?";
		Object[] args = {patient.getEmail(), patient.getOverTime(),
					patient.getFirstName(), patient.getLastName()};
		int[] types = {Types.VARCHAR, Types.BOOLEAN, Types.VARCHAR, Types.VARCHAR}
		int rows = jdbcTemplate.update(sql,args,types);
		return (rows==1); //True when the patient is updated successfully
	}

	@Override
	public boolean delete(Paitent patient) {
		String sql = "DELETE FROM Patient where Id=?";
		Object[] args = { patient.getId() };
		int[] types = {Types.VARCHAR};
		int rows = jdbcTemplate.update(sql,args,types);
		return (rows==1); //True if the patient is deleted successfully
	}

	@Override
	public void add(Patient patient){


		String sql = "insert into Patient(ID,Email,Overtime,FirstName,LastName) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{
				patient.getID(),
				patient.getEmail(),
				patient.getOverTime(),
				patient.getFirstName(),
				patient.getLastName()}, new int[]{Types.VARCHAR,Types.VARCHAR,
					Types.BOOLEAN,Types.VARCHAR,Types.VARCHAR});

	}

	@Override
	public List<Patient> finddAllPatients(){
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients");
		List<CusBaseInfo> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("Id").toString());
			patient.setEmail(map.get("Email").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("Overtime"))); //As OT is a bool
			patient.setFirstName(map.get("Firstname").toString());
			patient.setLastName(map.get("Lastname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}


	@Override
	public List<Patient> findByWord(String keyWord){
		List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from Patients where Firstname like %"+keyWord+"%");
		List<CusBaseInfo> patientLists =new ArrayList<>();
		for (Map<String.Object> map:list){
			Patient patient = new Patient();
			patient.setId(map.get("Id").toString());
			patient.setEmail(map.get("Email").toString());
			patient.setOverTime(Boolean.parseBoolean(map.get("Overtime"))); //As OT is a bool
			patient.setFirstName(map.get("Firstname").toString());
			patient.setLastName(map.get("Lastname").toString());
			patientLists.add(patient);
		}
		return patientLists;
	}
}
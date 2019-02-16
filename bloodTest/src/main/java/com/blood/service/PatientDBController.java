package com.blood.web;

import com.blood.pojo.Patient;
import com.blood.dao.impl.QPatientDaoImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Patient DB Controller
 * RESTful Web Service
 */

//Can be ignored if QPatientDaoImpl is refactored to service and just call it
//NOTE: This code have not finished yet!

@RestController
@RequestMapping(value = "/patient")
@Api(value = "Patient DB Controller", description = "Patient DB Controller")
public class PatientDBController{
    @Autowired
    private QueryPatientDao queryPatientDao;

    /**
     * Get All patients' infos
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value="Get All Patients' Info",notes = "Get All Patients Info")
    public List<Patient> findAllPatients(){
        return queryPatientDao.findAllPatients();
    }

    /**
     * Get All expired patients
     */
    @RequestMapping(value = "/getByExpired", method = RequestMethod.GET)
    @ApiOperation(value="Get All Expired Patients Info",note = "Get All Expired Patients Info")
    public List<Patient> findExpired() {
        return queryPatientDao.findExpired();
    }

    @RequestMapping(value= "/getByWord", method = RequestMethod.GET)
    public List<Patient> findByWord (@RequestParam("Word") String word){
        return queryPatientDao.findByWord(word);
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public void add(Patient patient){
        queryPatientDao.add(patient);
    }


    @RequestMapping(value = "/deletePatient", method = RequestMethod.Delete)
    public void delete(Patient patient){
        queryPatientDao.delete(patient);
    }

    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
    public void update(Patient patient){
        queryPatientDao.update(patient);
    }



}
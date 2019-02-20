package com.blood.controller;

import com.blood.pojo.Patient;

import java.util.List;

import com.blood.dao.QueryPatientDao;
import com.blood.dao.impl.QPatientDaoImpl;
import com.blood.service.ImportService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author Yilei Liang
 *
 * Patient DB Controller
 * RESTful Web Service
 */

//Can be ignored if QPatientDaoImpl is refactored to service and just call it
//NOTE: This code have not finished yet!

@RestController
@RequestMapping(value = "/patient")
//@Api(value = "Patient DB Controller", description = "Patient DB Controller")
public class PatientDBController{
    @Autowired
    private QueryPatientDao queryPatientDao;
    private ImportService importService;

    /**
     * Get All patients' infos
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    //@ApiOperation(value="Get All Patients' Info",notes = "Get All Patients Info")
    public List<Patient> findAllPatients(){
        return queryPatientDao.findAllPatients();
    }

    /**
     * Get All expired patients
     */
    @RequestMapping(value = "/getByExpired", method = RequestMethod.GET)
    //@ApiOperation(value="Get All Expired Patients Info",note = "Get All Expired Patients Info")
    public List<Patient> findExpired() {
        return queryPatientDao.findExpired();
    }

    @RequestMapping(value= "/getByForename", method = RequestMethod.GET)
    public List<Patient> findByForename (@RequestParam("Word") String word){
        return queryPatientDao.findByForename(word);
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public void add(Patient patient){
        queryPatientDao.add(patient);
    }


    @RequestMapping(value = "/deletePatient", method = RequestMethod.POST)
    public void delete(Patient patient){
        queryPatientDao.delete(patient);
    }

    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
    public void update(Patient patient){
        queryPatientDao.update(patient);
    }


    /**
     * Import the spreadsheet to DB
     */
    @RequestMapping(value = "/importSpreadsheet", method = RequestMethod.POST)
    public void importSpreadsheet(String fileLocation){
        importService.load(fileLocation);
    }

}
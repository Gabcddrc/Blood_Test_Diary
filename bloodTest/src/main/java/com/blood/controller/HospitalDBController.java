package com.blood.controller;

import com.blood.pojo.Hospital;
import com.blood.service.HospitalDBService;

import java.util.List;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * @Author Yilei Liang
 *
 * Hospital DB Controller
 * RESTful Web Service
 */



@RestController
@RequestMapping(value = "/hospital")
//@Api(value = "Hospital DB Controller", description = "Hospital DB Controller") 
public class HospitalDBController{
    @Autowired
    private HospitalDBService hospitalDBService;

    /**
     * Get all hospitals
     */
    @RequestMapping(value ="/all",  method = RequestMethod.GET)
    public List<Hospital> getAllHospitals(){
        return hospitalDBService.getAllHospital();
    }

    /**
     * Search hospitals by their name
     */
    @RequestMapping(value ="/getByName", method = RequestMethod.GET)
    public List<Hospital> searchByName(@RequestParam("Name") String name){
        return hospitalDBService.searchByName(name);
    }

    @RequestMapping(value="/updateHospital", method = RequestMethod.POST)
    public void updateHospitalInfo(Hospital hospital){
        hospitalDBService.updateHospitalInfo(hospital);
    }

    @RequestMapping(value="/addNewHospital", method = RequestMethod.POST)
    public void add(Hospital hospital){
        hospitalDBService.add(hospital);
    }

    @RequestMapping(value="/deleteHospital", method = RequestMethod.POST)
    public void delete(Hospital hospital){
        hospitalDBService.delete(hospital);
    }
}
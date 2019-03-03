package com.blood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import com.blood.pojo.Patient;
import com.blood.service.MailService;
//import com.blood.dao.impl.QPatientDaoImpl;
import com.blood.dao.QueryPatientDao;;

public class AutoMailService{
	@Autowired
	private QueryPatientDao qPatientDao;
	@Autowired
	private MailService mailService;
	
	private void autoSendNotification(){
		List<Patient> notifyList = qPatientDao.findExpired();
		mailService.sendNotification();
	}
	
}

 
package com.triarq.qprimentt.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.qprimentt.model.HistoryDetails;
import com.triarq.qprimentt.service.HistoryDetailsService;


@RestController
public class HistoryDetailsController {

	
	@Autowired
	HistoryDetailsService historydetailservice;
	
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(HistoryDetailsController.class);

	@GetMapping("/")
	public String hello() {
		return "Hello....Welcome to QPrimeNTTConnectionTest";
	}
	
	@GetMapping("/getHistoryDetails")
	public ResponseEntity<HistoryDetails> getHistoryDetails() {
		
		logger.debug("Entered in HistoryDetailsController - getHistoryDetails");

		List<HistoryDetails> historydlist = historydetailservice.findAllHistoryDetails();
		if (historydlist != null) {
			
			logger.debug("Exit in HistoryDetailsController - getHistoryDetails");
			return new ResponseEntity<HistoryDetails>(historydlist.get(0), HttpStatus.OK);
		} else {
			logger.debug("Exit in HistoryDetailsController - getHistoryDetails");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
}

package com.triarq.qprimentt.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
	
	@GetMapping("/gethostnameandip")
	public ResponseEntity<String> getHostname() throws UnknownHostException {
		InetAddress id = InetAddress.getLocalHost();
		String hostname = id.getHostName();
		String ip = id.getHostAddress();

		return new ResponseEntity<String>("hostname - " + hostname + " and ip - " + ip, HttpStatus.OK);
	}
	
	@GetMapping("/getpingrequest")
	public ResponseEntity<String> getPingRequest() throws IOException {
		String ipAddress1 = "10.91.182.68";
		String message1 = sendPingRequest(ipAddress1);
		String ipAddress2 = "10.91.182.132";
		String message2 = sendPingRequest(ipAddress2);
		String ipAddress3 = "10.91.182.196";
		String message3 = sendPingRequest(ipAddress3);
		return new ResponseEntity<String>(message1+" "+message2+" "+message3, HttpStatus.OK);

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
	
	public static String sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
		InetAddress id = InetAddress.getByName(ipAddress);
		
		if (id.isReachable(5000))
			return "Host is reachable "+id.getHostName()+"";
		else
			return "Sorry ! We can't reach to this host";
	}
}

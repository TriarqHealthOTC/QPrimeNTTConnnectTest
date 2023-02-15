package com.triarq.qprimentt.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triarq.qprimentt.controller.HistoryDetailsController;
import com.triarq.qprimentt.model.HistoryDetails;
import com.triarq.qprimentt.repository.HistoryDetailsRepository;

@Service
public class HistoryDetailsServiceImpl implements HistoryDetailsService{

	@Autowired
	HistoryDetailsRepository psrepo;

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(HistoryDetailsController.class);

	@Override
	public List<HistoryDetails> findAllHistoryDetails() {
        
		logger.debug("Entered in HistoryDetailsServiceImpl - findAllHistoryDetails");
		
		List<HistoryDetails> historydetials = null;

		try {
			historydetials = psrepo.findAll();
		} catch (Exception e) {
			logger.error(e);

		}
		logger.debug("Exit in HistoryDetailsServiceImpl - findAllHistoryDetails");
		return historydetials;
	}
}

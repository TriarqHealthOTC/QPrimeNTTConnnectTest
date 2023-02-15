package com.triarq.qprimentt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.triarq.qprimentt.model.HistoryDetails;

@Service
public interface HistoryDetailsService {

	List<HistoryDetails> findAllHistoryDetails();

}

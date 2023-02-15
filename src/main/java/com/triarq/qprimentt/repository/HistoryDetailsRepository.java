package com.triarq.qprimentt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triarq.qprimentt.model.HistoryDetails;

@Repository
public interface HistoryDetailsRepository extends JpaRepository<HistoryDetails,Long>{

}

package com.triarq.qprimentt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HistoryDetails {

	@Id
	Long nHistoryDetailsID;
	Long nHistoryID;
	Long nCategoryID;
	public HistoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryDetails(Long nHistoryDetailsID, Long nHistoryID, Long nCategoryID) {
		super();
		this.nHistoryDetailsID = nHistoryDetailsID;
		this.nHistoryID = nHistoryID;
		this.nCategoryID = nCategoryID;
	}
	public Long getnHistoryDetailsID() {
		return nHistoryDetailsID;
	}
	public void setnHistoryDetailsID(Long nHistoryDetailsID) {
		this.nHistoryDetailsID = nHistoryDetailsID;
	}
	public Long getnHistoryID() {
		return nHistoryID;
	}
	public void setnHistoryID(Long nHistoryID) {
		this.nHistoryID = nHistoryID;
	}
	public Long getnCategoryID() {
		return nCategoryID;
	}
	public void setnCategoryID(Long nCategoryID) {
		this.nCategoryID = nCategoryID;
	}
	@Override
	public String toString() {
		return "HistoryDetails [nHistoryDetailsID=" + nHistoryDetailsID + ", nHistoryID=" + nHistoryID
				+ ", nCategoryID=" + nCategoryID + "]";
	}
	
	
	
}

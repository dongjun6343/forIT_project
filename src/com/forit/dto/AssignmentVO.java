package com.forit.dto;

import java.sql.Timestamp;

public class AssignmentVO {
	private int assNum;
	private String assTitle;
	private Timestamp assDate;
	private String assContent;
	private int assCount;
	private char assActive;
	private String adminId;

	

	public int getAssNum() {
		return assNum;
	}



	public void setAssNum(int assNum) {
		this.assNum = assNum;
	}



	public String getAssTitle() {
		return assTitle;
	}



	public void setAssTitle(String assTitle) {
		this.assTitle = assTitle;
	}



	public Timestamp getAssDate() {
		return assDate;
	}



	public void setAssDate(Timestamp assDate) {
		this.assDate = assDate;
	}



	public String getAssContent() {
		return assContent;
	}



	public void setAssContent(String assContent) {
		this.assContent = assContent;
	}



	public int getAssCount() {
		return assCount;
	}



	public void setAssCount(int assCount) {
		this.assCount = assCount;
	}



	public char getAssActive() {
		return assActive;
	}



	public void setAssActive(char assActive) {
		this.assActive = assActive;
	}



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



	@Override
	public String toString() {
		return "AssignmemtVO [ASSNUM=" + assNum + ", ASSTITLE=" + assTitle + ", ASSDATE=" + assDate + ", ASSCONTENT="
				+ assContent + "assCount="+ assCount + "assActive=" + assActive + ", ADMINID =" + adminId + "]";
	}

}
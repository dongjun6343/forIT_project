package com.forit.dto;

import java.sql.Timestamp;

public class NoticeVO {
	private int nNum;
	private String nTitle;
	private Timestamp nDate;
	private String nContent;
	private int nCount;
	private char nMust;
	private String adminId;
	
	public int getnNum() {
		return nNum;
	}
	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public Timestamp getnDate() {
		return nDate;
	}
	public void setnDate(Timestamp nDate) {
		this.nDate = nDate;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public int getnCount() {
		return nCount;
	}
	public void setnCount(int nCount) {
		this.nCount = nCount;
	}
	public char getnMust() {
		return nMust;
	}
	public void setnMust(char nMust) {
		this.nMust = nMust;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "NoticeVO [nNum=" + nNum + ", nTitle=" + nTitle + ", nDate=" + nDate + ", nContent=" + nContent
				+ ", nCount=" + nCount + ", nMust=" + nMust + ", adminId=" + adminId + "]";
	}

}
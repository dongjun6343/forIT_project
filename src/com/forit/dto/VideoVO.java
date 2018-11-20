package com.forit.dto;

import java.sql.Timestamp;

//게시글 정보를 저장하는 Vo클래스
public class VideoVO {

	// 강의 자료 테이블 db
	private int vNum;
	private String vTitle;
	private Timestamp vDate;
	private String vContent;
	private String vSubject; //데이터 타입확인 
	private String vUrl;
	private int vCount;
	private String adminId;
	
	
	
	public int getvNum() {
		return vNum;
	}
	public void setvNum(int vNUM) {
		this.vNum = vNUM;
	}
	public String getvTitle() {
		return vTitle;
	}
	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}
	public Timestamp getvDate() {
		return vDate;
	}
	public void setvDate(Timestamp vDate) {
		this.vDate = vDate;
	}
	public String getvContent() {
		return vContent;
	}
	public void setvContent(String vContent) {
		this.vContent = vContent;
	}
	public String getvSubject() {
		return vSubject;
	}
	public void setvSubject(String vSubject) {
		this.vSubject = vSubject;
	}
	public String getvUrl() {
		return vUrl;
	}
	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}
	public int getvCount() {
		return vCount;
	}
	public void setvCount(int vCount) {
		this.vCount = vCount;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminID(String adminId) {
		this.adminId = adminId;
	}
	//to string overriding
	@Override
	public String toString() {
		return "VideoVO [vNum=" + vNum + ", vTitle=" + vTitle + ", vDate=" + vDate + ", vContent=" + vContent
				+ ", vSubject=" + vSubject + ", vUrl=" + vUrl + ", vCount=" + vCount + ", adminId=" + adminId + "]";
	}
	
	
	

}
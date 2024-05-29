package com.kh.journey.wish.vo;

public class WishVo {
	
	private String no;
	private String memNo;
	private String roomNo;
	private String grade;
	private String roomName;
	private String accomAddress;
	private String accomImgUrl;
	private String roomWeekdayPrice;
	private String roomWeekendPrice;
	
	
	public WishVo() {

	}


	public WishVo(String no, String memNo, String roomNo, String grade, String roomName, String accomAddress,
			String accomImgUrl, String roomWeekdayPrice, String roomWeekendPrice) {
		this.no = no;
		this.memNo = memNo;
		this.roomNo = roomNo;
		this.grade = grade;
		this.roomName = roomName;
		this.accomAddress = accomAddress;
		this.accomImgUrl = accomImgUrl;
		this.roomWeekdayPrice = roomWeekdayPrice;
		this.roomWeekendPrice = roomWeekendPrice;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getMemNo() {
		return memNo;
	}


	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public String getAccomAddress() {
		return accomAddress;
	}


	public void setAccomAddress(String accomAddress) {
		this.accomAddress = accomAddress;
	}


	public String getAccomImgUrl() {
		return accomImgUrl;
	}


	public void setAccomImgUrl(String accomImgUrl) {
		this.accomImgUrl = accomImgUrl;
	}


	public String getRoomWeekdayPrice() {
		return roomWeekdayPrice;
	}


	public void setRoomWeekdayPrice(String roomWeekdayPrice) {
		this.roomWeekdayPrice = roomWeekdayPrice;
	}


	public String getRoomWeekendPrice() {
		return roomWeekendPrice;
	}


	public void setRoomWeekendPrice(String roomWeekendPrice) {
		this.roomWeekendPrice = roomWeekendPrice;
	}


	@Override
	public String toString() {
		return "WishVo [no=" + no + ", memNo=" + memNo + ", roomNo=" + roomNo + ", grade=" + grade + ", roomName="
				+ roomName + ", accomAddress=" + accomAddress + ", accomImgUrl=" + accomImgUrl + ", roomWeekdayPrice="
				+ roomWeekdayPrice + ", roomWeekendPrice=" + roomWeekendPrice + "]";
	}
	
	
}

package com.kh.journey.wish.vo;

public class WishVo {
	
	private String no;
	private String memNo;
	private String roomNo;
	private String grade;
	private String roomName;
	
	public WishVo() {

	}

	public WishVo(String no, String memNo, String roomNo, String grade, String roomName) {
		this.no = no;
		this.memNo = memNo;
		this.roomNo = roomNo;
		this.grade = grade;
		this.roomName = roomName;
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

	@Override
	public String toString() {
		return "WishVo [no=" + no + ", memNo=" + memNo + ", roomNo=" + roomNo + ", grade=" + grade + ", roomName="
				+ roomName + "]";
	}
	
}
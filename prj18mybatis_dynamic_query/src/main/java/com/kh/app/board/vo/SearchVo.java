package com.kh.app.board.vo;

public class SearchVo {
	
	private String type;
	private String value;
	
	
	public SearchVo() {

	}
	
	
	public SearchVo(String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	
	



	String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "SearchVo [type=" + type + ", value=" + value + "]";
	} 
	
	

}

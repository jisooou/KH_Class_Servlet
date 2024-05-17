package com.kh.app.board.vo;

public class AttachmentVo {
	
	private String originName; 
	private String changeName;
	
	public AttachmentVo() {
		
	}

	public AttachmentVo(String originName, String changeName) {
		super();
		this.originName = originName;
		this.changeName = changeName;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	@Override
	public String toString() {
		return "AttachmentVo [originName=" + originName + ", changeName=" + changeName + "]";
	}
	
}

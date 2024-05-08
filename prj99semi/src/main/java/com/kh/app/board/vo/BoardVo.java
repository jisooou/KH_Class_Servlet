package com.kh.app.board.vo;

public class BoardVo {
	
	private String no;
	private String title;
	private String content;
	private String categoryNo;
	private String categoryName;
	private String writerNo;
	private String nick;
	private String hit;
	private String createDate;
	private String delYn;
	
	public BoardVo() {
		super();
	}

	public BoardVo(String no, String title, String content, String categoryNo, String categoryName, String writerNo,
			String nick, String hit, String createDate, String delYn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.writerNo = writerNo;
		this.nick = nick;
		this.hit = hit;
		this.createDate = createDate;
		this.delYn = delYn;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", categoryNo=" + categoryNo
				+ ", categoryName=" + categoryName + ", writerNo=" + writerNo + ", nick=" + nick + ", hit=" + hit
				+ ", createDate=" + createDate + ", delYn=" + delYn + "]";
	}

	

}

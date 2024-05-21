package com.kh.journey.member.vo;

//임시 로그인 - MemberLoginController, MemberVo, login.jsp 임시 테스트용. 

public class MemberVo {
    private String no;
    private String id;
    private String name;
    
    public MemberVo() {
    	
    }

    public MemberVo(String no, String id, String name) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
	}

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", name=" + name + "]";
	}
    
}
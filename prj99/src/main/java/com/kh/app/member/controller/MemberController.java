package com.kh.app.member.controller;

public class MemberController {
	
	public String login() {
		System.out.println("로그인~~~");
		return "common/result";
	}
	
	public String join() {
		System.out.println("회원가입~~~");
		return "member/loginPage";
	}

}

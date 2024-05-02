package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	public int join(MemberVo vo) throws Exception{
		
		String memberId = vo.getMemberId();
		String memberPwd = vo.getMemberPwd();
		String memberPwd2 = vo.getMemberPwd2();
		String memberNick = vo.getMemberNick();
		
//		복잡한 작업 (비즈니스 로직 + SQL) -> 유효성 검사하기
//		아이디 길이 검사하기 
		boolean isValid = true; 
		if(memberId.length() < 4 || memberId.length() > 12) {
			isValid = false; 
		}
//		패스워드 길이 검사하기
		if(memberPwd.length() < 4 || memberPwd.length() > 12) {
			isValid = false; 
		}
//		패스워드 일치여부 검사하기
		if(!memberPwd.equals(memberPwd2)) {
			isValid = false; 
		}
		if(memberNick.contains("관리자") || memberNick.contains("운영자")) {
			isValid = false; 
		}
		
		if(isValid == false) {
			return 0;
		}
		
		MemberDao dao = new MemberDao();
		int result = dao.join(vo);
		
		return result;
		
	}

	public MemberVo login(MemberVo vo) throws Exception {
		
//		비즈니스 로직
		
//		SQL
		MemberDao dao = new MemberDao();
		MemberVo loginMemberVo = dao.login(vo);
		
		return loginMemberVo;
		
	}
}

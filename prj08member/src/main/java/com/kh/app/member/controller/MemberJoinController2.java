package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join2")
public class MemberJoinController2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwdCheck = req.getParameter("memberPwdCheck");
		String memberNick = req.getParameter("memberNick");
		
//		데이터 뭉치기
		MemberVo vo = new MemberVo(memberId, memberPwd, memberNick);
		
		
//		복잡한 작업
//		if(!memberPwd.equals(memberPwdCheck)) {
//			new MemberDao().insertMember(데이터);
//			System.out.println("회원가입 실패");
//		}else {
//			
//			System.out.println("회원가입 성공");
//		}
//		
		
		
		String pwd1 = req.getParameter("memberPwd");
		String pwd2 = req.getParameter("memberPwdCheck");
		String msg = "";
		if(pwd1.equals(pwd2)){
			msg = "성공!";	
		}else{
			msg = "실패...";		
		}
		req.setAttribute("x", msg);
		
//		결과처리 == 문자열 내보내기
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}

}

package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login2")
public class MemberLoginController2 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("로그인 요청 들어옴 ~~~");
		//	데이터 꺼내기
		//	input type의 name을 가지고 옴
		String memberId = req.getParameter("memberId"); 
		String memberPwd = req.getParameter("memberPwd"); 
		
		//	복잡한 작업 //id가 user01이고 pwd가 1234이면 로그인 성공으로 간주하기
		if("user01".equals(memberId) && "1234".equals(memberPwd)) {
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);		
		}else {
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
		
			
	}
}

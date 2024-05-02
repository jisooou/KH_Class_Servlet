package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

//	로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
//	로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
//		데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setMemberId(memberId);
		vo.setMemberPwd(memberPwd);
		
//		복잡한 작업
		MemberService ms = new MemberService();
		MemberVo loginMemberVo = null;
		try {
			loginMemberVo = ms.login(vo);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "로그인하는 중에 에러 발생함!!!");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			return;
		}
		
//		결과
		if(loginMemberVo != null) {
			req.setAttribute("msg", "로그인 성공!");			
		}else {
			req.setAttribute("msg", "로그인 실패...");	
		}
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		
	}
}

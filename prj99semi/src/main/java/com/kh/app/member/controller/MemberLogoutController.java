package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//		세션 가지고 오기
		HttpSession session = req.getSession();
		//		세션.만료();
		session.invalidate();
		
		//		로그아웃 하면 client가 홈페이지를 볼 수 있도록 하기
		//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		resp.sendRedirect("/app/home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

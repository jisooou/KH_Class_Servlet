package com.kh.app.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.controller.MemberController;

@WebServlet("/*")
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HomeController.service() called...");
		
		String url = req.getRequestURL().toString();
		System.out.println("url : " + url);
		
		String method = req.getMethod();
		System.out.println("method : " + method);
		
		MemberController mc = new MemberController();
		
		String str = "";
		if(url.endsWith("member/login")) {
			str = mc.login();
		}else if(url.endsWith("member/join")) {
			str = mc.join();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/" + str + ".jsp").forward(req, resp);
	}
	
}

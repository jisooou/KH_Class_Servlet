package com.kh.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.vo.MemberVo;

@WebServlet(value = "/login")
public class MemberController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req : request 객체 
//		getParameter : key값, key값을 이용해서 value를 꺼내온다.
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		
//		객체 만들기
		MemberVo vo = new MemberVo(memberId, memberPwd);
		
//		resp : 응답이랑 관련된 내용을 담아주는 객체
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<style>");
		resp.getWriter().write("h1 {");
		resp.getWriter().write("	background-color:gray;");
		resp.getWriter().write("}");
		resp.getWriter().write("</style>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<h1>환영합니다~~~!</h1>");
		resp.getWriter().write("<h1>");
		resp.getWriter().write(vo.getMemberId() + "님 로그인 성공 !");
		resp.getWriter().write("</h1>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
	}
	
}

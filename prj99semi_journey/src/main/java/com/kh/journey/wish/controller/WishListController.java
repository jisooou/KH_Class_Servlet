package com.kh.journey.wish.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.wish.service.WishService;
import com.kh.journey.wish.vo.WishVo;

@WebServlet("/wish/list")
public class WishListController extends HttpServlet{
	
	private WishService ws;
	
	public WishListController() {
		this.ws =  new WishService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
            MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
            if (loginMemberVo == null) {
                resp.sendRedirect("/journey/member/login");
                return;
            }
            String memberNo = loginMemberVo.getNo();
			
//			데이터 꺼내기 
            List<WishVo> voList = ws.selectWishList(memberNo);
			
//			결과 	
			req.setAttribute("voList", voList);			
			req.getRequestDispatcher("/WEB-INF/views/wish/list.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
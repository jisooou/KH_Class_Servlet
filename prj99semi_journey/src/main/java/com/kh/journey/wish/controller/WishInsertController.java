package com.kh.journey.wish.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.journey.member.vo.MemberVo;
import com.kh.journey.wish.service.WishService;
import com.kh.journey.wish.vo.WishVo;

@WebServlet("/wish/insert")
public class WishInsertController extends HttpServlet {
	
	
//	위시리스트 화면 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		home 말고 insert로 수정함. 
		req.getRequestDispatcher("/WEB-INF/views/wish/insert.jsp").forward(req, resp);
	}

	
//	위시리스트 구현
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 try{
	            // 로그인 확인
	            HttpSession session = req.getSession();
	            MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
	            if (loginMemberVo == null) {
//	                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	                resp.getWriter().write("로그인이 필요합니다.");
//	                return;
	            	throw new Exception("로그인이 필요합니다.");
	            }

	            // 데이터 꺼내기
	            String roomNo = req.getParameter("roomNo");
	            String memberNo = loginMemberVo.getNo();

	            // 데이터 뭉치기
	            WishVo vo = new WishVo();
	            vo.setMemNo(memberNo);
	            vo.setRoomNo(roomNo);

	            // 서비스 호출
	            WishService ws = new WishService();
	            int result = ws.insert(vo);

	            // 결과
	            if (result < 1) {
	                throw new Exception("위시리스트 등록을 실패했습니다.");
	            }
	            resp.sendRedirect("/journey/wish/list");

	        }catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				req.setAttribute("errMsg", e.getMessage());
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	        }
		
	}

}
package com.kh.journey.wish.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		try {
//			데이터 꺼내기
			String no = req.getParameter("no");
			String mem_no = req.getParameter("memNo");
			String room_no = req.getParameter("roomNo");
			
//			데이터 뭉치기
			WishVo vo = new WishVo();
			vo.setNo(no);
			vo.setMemNo(mem_no);
			vo.setRoomNo(room_no);
			
//			서비스 호출 
			WishService ws = new WishService();
			int result = ws.insert(vo);
			
//			결과
			if(result < 1) {
				throw new Exception("게시물 작성 실패 ㅠ~ㅠ");
			}
			resp.sendRedirect("/app/board/list");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}

}

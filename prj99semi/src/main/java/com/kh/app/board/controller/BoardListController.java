package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	private BoardService bs;
			
	public BoardListController() {
		this.bs =  new BoardService();
	}
	
//	게시글 목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
//			데이터 꺼내기 
			
			int listCount = bs.getBoardCnt();
			String x = req.getParameter("pno") == null ? "1" : req.getParameter("pno");
			int currentPage = Integer.parseInt(x); 
			int pageLimit = 5; 
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
//			복잡한 작업
			List<BoardVo> voList = bs.selectBoardList(pvo);
			
//			결과 	
			req.setAttribute("voList", voList);
			req.setAttribute("pvo", pvo);			
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			
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

package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		try {
//			데이터 꺼내기
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
//			데이터 뭉치기
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
//			서비스 호출 
			BoardService bs = new BoardService(); 
			int result = bs.insert(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result :" + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}

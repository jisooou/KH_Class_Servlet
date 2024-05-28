package com.kh.app.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.vo.PageVo;
import com.kh.app.notice.service.NoticeService;
import com.kh.app.notice.vo.NoticeVo;

@WebServlet("/rest/notice/list")
public class NoticeListRestController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			NoticeService ns = new NoticeService();

//			data
			String pno_ = req.getParameter("pno");
			int pno = Integer.parseInt(pno_);
			int listCount = ns.getNoticeCount(); 
			int currentPage = pno;
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

//			service
			List<NoticeVo> voList = ns.getNoticeList(pvo);

//			result
			Gson gson = new Gson();
			String jsonStr = gson.toJson(voList);
			resp.setContentType("application/json; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.write(jsonStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}

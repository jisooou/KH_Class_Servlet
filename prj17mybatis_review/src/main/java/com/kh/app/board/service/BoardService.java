package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.SqlSessionTemplate;

public class BoardService {
	
	private final BoardDao dao;
	
	public BoardService() {
		this.dao = new BoardDao();
	}

	public int insert(BoardVo vo) throws Exception{
		
//		비즈니스 로직 없음
		
//		sql session 
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.insertBoard(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
		
	}

	public List<BoardVo> getBoardList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> voList = dao.getBoardList(ss);
		ss.close();
		return voList;
	}

}

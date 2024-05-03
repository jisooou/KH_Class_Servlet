package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;
import static com.kh.app.db.JDBCTemplate.*;


public class BoardService {
	
	private final BoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}

	
	
	public int insert(BoardVo vo) throws Exception{
//		비즈니스로직
		if(vo.getTitle().contains("ㅆ")) {
			throw new Exception("욕하지 마세요-제목");
		}
		
		if(vo.getContent().contains("ㅆ")) {
			throw new Exception("욕하지 마세요-내용");
		}
		
		
//		DAO 호출
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insert(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}



	public List<BoardVo> selectBoardList() throws Exception{
		
//		비즈니스 로직 - 생략
		
//		DAO 호출
		Connection conn = getConnection();
		List<BoardVo> voList = dao.selectBoardList(conn);
		
//		트랜잭션 처리해줄 거 없음	
		close(conn);
		
		return voList; 
		
	}

}

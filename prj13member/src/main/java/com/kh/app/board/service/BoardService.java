package com.kh.app.board.service;

import java.sql.Connection;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardService {

	public int insert(BoardVo vo) throws Exception{
//		비즈니스 로직 
		
		
//		conn
		Connection conn = JDBCTemplate.getConnection();
		
//		SQL
		BoardDao dao = new BoardDao();
		int result = dao.insert(conn, vo);
		
//		service에서 트랜잭션 처리해야 한다. (?)
		if(result == 1){
			conn.commit();
		}else {
			conn.rollback();
		}
		
		return result;
		
	}

}


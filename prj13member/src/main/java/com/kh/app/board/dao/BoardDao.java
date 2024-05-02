package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;

public class BoardDao {

//	parameter에 Connection을 추가해서 오류 없애기
	public int insert(Connection conn, BoardVo vo) throws Exception{
		
//		SQL
		String sql = "INSERT INTO BOARD(TITLE, CONTENT) VALUES(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		return result;
	}

}


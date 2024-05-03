package com.kh.app.board.dao;

import static com.kh.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	public int insert(Connection conn, BoardVo vo) throws Exception{
		
//		SQL
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT, CATEGORY_NO, WRITER_NO) VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getCategoryNo());
		pstmt.setString(4, vo.getWriterNo());
		
		int result = pstmt.executeUpdate();
		
		close(conn);
		
		return result;
	}

//	게시글 목록 조회
	public List<BoardVo> selectBoardList(Connection conn) throws Exception {
		
//		SQL
		String sql = "SELECT * FROM BOARD WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> voList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String categoryNo = rs.getString("CATEGORY_NO");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String createDate = rs.getString("CREATE_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCategoryNo(categoryNo);
			vo.setWriterNo(writerNo);
			vo.setHit(hit);
			vo.setCreateDate(createDate);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
			
		close(pstmt);
		close(rs);
		return voList;
	}

}

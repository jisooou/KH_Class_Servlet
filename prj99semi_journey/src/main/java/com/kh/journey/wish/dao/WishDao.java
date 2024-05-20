package com.kh.journey.wish.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.kh.journey.wish.vo.WishVo;

public class WishDao {

	public int insert(Connection conn, WishVo vo) throws Exception{
		
//		SQL
//		SQL 구문 다시
		String sql = "INSERT INTO WISH_LIST(NO, MEM_NO, ROOM_NO) VALUES(SEQ_WISH_LIST.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemNo());
		pstmt.setString(2, vo.getRoomNo());
//		pstmt.setString(3, vo.getGrade());
//		pstmt.setString(4, vo.getRoomName());
		
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
		
	}

	public int getWishCnt(Connection conn) throws Exception{
//		SQL
//		SQL 구문 다시
		String sql = "SELECT COUNT(NO) FROM WISH_LIST WHERE DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int cnt = 0; 
		if(rs.next()) {
			cnt = rs.getInt(1);
		}
		
		close(rs);
		close(pstmt);
		
		return cnt;
	}

//	public List<WishVo> selectWishList(Connection conn) throws Exception{
//		
//		
//		
//	}

}

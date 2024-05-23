package com.kh.journey.wish.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.wish.vo.WishVo;

public class WishDao {

	public int insert(Connection conn, WishVo vo) throws Exception{
		
//		SQL
		String sql = "INSERT INTO WISH_LIST(NO, MEM_NO, ROOM_NO) VALUES(SEQ_WISH_LIST.NEXTVAL, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getMemNo());
        pstmt.setString(2, vo.getRoomNo());

        int result = pstmt.executeUpdate();

        close(pstmt);

        return result;	
	}


	public List<WishVo> selectWishList(Connection conn, String memberNo) throws Exception{
		
		String sql = "SELECT * FROM WISH_LIST WHERE MEM_NO = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberNo);
        ResultSet rs = pstmt.executeQuery();

        List<WishVo> wishList = new ArrayList<>();
        while (rs.next()) {
            WishVo wish = new WishVo();
            wish.setNo(rs.getString("NO"));
            wish.setMemNo(rs.getString("MEM_NO"));
            wish.setRoomNo(rs.getString("ROOM_NO"));
            wishList.add(wish);
        }

        close(rs);
        close(pstmt);

        return wishList;
		
	}


	public int delete(Connection conn, WishVo wishVo) throws Exception {

//		SQL
		String sql = "DELETE FROM WISH_LIST WHERE NO = ? AND MEM_NO = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, wishVo.getNo());
        pstmt.setString(2, wishVo.getMemNo());
        int result = pstmt.executeUpdate();
        
        close(pstmt);
        
        return result;
    }



}
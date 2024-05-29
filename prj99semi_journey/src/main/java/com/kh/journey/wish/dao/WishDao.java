package com.kh.journey.wish.dao;

import static com.kh.journey.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.journey.accom.vo.AccomVo;
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
		
//		SQL
		String sql = "SELECT W.NO , W.MEM_NO , W.ROOM_NO , R.GRADE , R.NAME , A.ADDRESS , A.IMG_URL , R.WEEKDAY_PRICE , R.WEEKEND_PRICE FROM WISH_LIST W JOIN ROOM R ON W.ROOM_NO = R.NO JOIN ACCOMMODATION A ON R.ACCOM_NO = A.NO WHERE W.MEM_NO = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberNo);
        ResultSet rs = pstmt.executeQuery();

        List<WishVo> wishList = new ArrayList<WishVo>();
        while (rs.next()) {
        	String no = rs.getString("NO");
        	String memNo = rs.getString("MEM_NO");
        	String roomNo = rs.getString("ROOM_NO");
        	String grade = rs.getString("GRADE");
        	String roomName = rs.getString("NAME");
        	String accomAddress = rs.getString("ADDRESS");
        	String accomImgUrl = rs.getString("IMG_URL");
        	String roomWeekdayPrice = rs.getString("WEEKDAY_PRICE");
        	String roomWeekendPrice = rs.getString("WEEKEND_PRICE");
        	
            WishVo vo = new WishVo();
			vo.setNo(no);
			vo.setMemNo(memNo);
			vo.setRoomNo(roomNo);
			vo.setGrade(grade);
			vo.setRoomName(roomName);
			vo.setAccomAddress(accomAddress);
			vo.setAccomImgUrl(accomImgUrl);
			vo.setRoomWeekdayPrice(roomWeekdayPrice);
			vo.setRoomWeekendPrice(roomWeekendPrice);

			wishList.add(vo);
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
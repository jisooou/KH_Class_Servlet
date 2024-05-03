package com.kh.app.member.dao;

import static com.kh.app.db.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int join(Connection conn, MemberVo vo) throws Exception{
		
		String sql = "INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES( SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public MemberVo login(Connection conn, MemberVo vo) throws Exception{
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs = pstmt.executeQuery();
		

	      MemberVo loginMemberVo = null;
	      if(rs.next()) {
	         String no = rs.getString("NO");
	         String id = rs.getString("ID");
	         String pwd = rs.getString("PWD");
	         String nick = rs.getString("NICK");
	         String delYn = rs.getString("DEL_YN");
	         String enrollDate = rs.getString("ENROLL_DATE");
	         String modifyDate = rs.getString("MODIFY_DATE");
	         
	         loginMemberVo = new MemberVo();
	         loginMemberVo.setNo(no);
	         loginMemberVo.setId(id);
	         loginMemberVo.setPwd(pwd);
	         loginMemberVo.setNick(nick);
	         loginMemberVo.setDelYn(delYn);
	         loginMemberVo.setEnrollDate(enrollDate);
	         loginMemberVo.setModifyDate(modifyDate);
	      }
	      
	      
	      close(rs);
	      close(pstmt);
	      
	      return loginMemberVo;
	}

	public int edit(Connection conn, MemberVo vo) throws Exception{
		
//		SQL
		String sql = "UPDATE MEMBER SET PWD = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPwd());
		pstmt.setString(2, vo.getNo());
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
	}

	public int quit(Connection conn, String no) throws Exception {
		
//		SQL
		String sql = "UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		close(pstmt);
		
		return result;
		
	}

}
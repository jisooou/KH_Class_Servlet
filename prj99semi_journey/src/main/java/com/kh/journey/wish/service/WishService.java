package com.kh.journey.wish.service;

import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.close;
import static com.kh.journey.db.JDBCTemplate.commit;
import static com.kh.journey.db.JDBCTemplate.getConnection;
import static com.kh.journey.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.journey.wish.dao.WishDao;
import com.kh.journey.wish.vo.WishVo;

public class WishService {
	
	private final WishDao dao;

	public WishService() {
		dao = new WishDao();
	}


	public int insert(WishVo vo) throws Exception{
		
//		비즈니스로직 - 일단 없음.
		
//		DAO 호출
		Connection conn = getConnection();
		int result = dao.insert(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result; 

	}


	public int getBoardCnt() throws Exception{
//		비즈니스 로직 - 일단 없음
		
//		SQL
		Connection conn = getConnection();
		int cnt = dao.getWishCnt(conn);
		
		close(conn);
		
		return cnt;
	}


//	public List<WishVo> selectBoardList() throws Exception {
////		비즈니스 로직 -
//		
////		DAO 호출
//		Connection conn = getConnection();
//		List<WishVo> voList = dao.selectWishList(conn);
//		
////		트랜잭션 처리해줄 거 없음	
//		close(conn);
//		
//		return voList; 
//	}

}

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

	
	public List<WishVo> selectWishList(String memberNo) throws Exception{

// 		비즈니스 로직 - x

// 		Dao 호출
		Connection conn = getConnection();
		List<WishVo> wishList = dao.selectWishList(conn, memberNo);
		
	//	트랜잭션 처리해줄 거 없음	
		close(conn);
		
		return wishList; 
		
	}


	public int delete(WishVo wishVo) throws Exception{
		
//		비즈니스 로직
		
//		DAO 호출
		Connection conn = getConnection();
		int result = dao.delete(conn, wishVo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
			throw new Exception("게시글 삭제 중에 예외 발생...");
		}
		close(conn);
		
		return result;
	}

}
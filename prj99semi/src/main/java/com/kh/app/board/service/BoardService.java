package com.kh.app.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
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


// 게시글 상세 조회
	public BoardVo getBoardByNo(String no, boolean isSelf) throws Exception{
		
//		비즈니스 로직 - 처리할 거 없음

//		DAO 호출
		Connection conn = null;
		BoardVo vo = null;
		try {
			conn = getConnection();
			
//			본인이 아닐 때 -> 조회수 증가 O
			int result = 1;
			if(!isSelf) {
				result = dao.increaseHit(conn, no);				
			}
			
			vo = dao.getBoardByNo(conn, no);
			if(result == 1 && vo != null) {
				commit(conn);
			}else {
				rollback(conn);
				throw new Exception("[ERROR-B001]게시글 조회수 증가 실패...");
			}
		}finally {
			close(conn);			
		}
		
		
		return vo; 
		
	}



//	카테고리 목록 조회
	public List<CategoryVo> getCategoryVoList() throws Exception {

//		비즈니스 로직 - 필요없음
		
//		DAO 호출
		Connection conn = getConnection();
		List<CategoryVo> categoryVoList = dao.getCategoryVoList(conn);
				 
		close(conn);
		
		return categoryVoList;
		
	}


// 게시글 수정
	public int edit(BoardVo vo) throws Exception{
		
//		비즈니스 로직
		if(vo.getTitle().contains("18")) {
			throw new Exception("욕하지 마세요 - 제목");
		}
		
		if(vo.getContent().contains("18")) {
			throw new Exception("욕하지 마세요 - 내용");
		}
		
//		DAO 호출
		Connection conn = getConnection();
		int result = dao.edit(conn, vo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result; 

	}



	public int delete(BoardVo boardVo) throws Exception{
//		비즈니스 로직
		
//		DAO 호출
		Connection conn = getConnection();
		int result = dao.delete(conn, boardVo);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
			throw new Exception("게시글 삭제 예외 발생...");
		}
		close(conn);
		
		return result;
		
	}

}

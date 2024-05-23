package com.kh.app.board.service;

import static com.kh.app.db.JDBCTemplate.close;
import static com.kh.app.db.JDBCTemplate.commit;
import static com.kh.app.db.JDBCTemplate.getConnection;
import static com.kh.app.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.AttachmentVo;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.board.vo.PageVo;
import com.kh.app.db.JDBCTemplate;
import static com.kh.app.db.SqlSessionTemplate.getSqlSession;


public class BoardService {
	
	private final BoardDao dao;
	private Object attVo;
	
	public BoardService() {
		dao = new BoardDao();
	}

	
	
	public int insert(BoardVo vo, List<AttachmentVo> attVoList) throws Exception{
		System.out.println("service called...");
//		비즈니스로직
		if(vo.getTitle().contains("ㅆ")) {
			throw new Exception("욕하지 마세요-제목");
		}
		
		if(vo.getContent().contains("ㅆ")) {
			throw new Exception("욕하지 마세요-내용");
		}
		
		
//		DAO 호출
	
		SqlSession ss = getSqlSession();
		int result = dao.insert(ss, vo);
		System.out.println("dao result : " + result);
		
		int attResult = 1;
		if(attVoList.size() > 0) {
			attResult = dao.insertBoardAttachment(ss, attVoList);
			System.out.println("attResult : " + attResult);
		}
		
		if(result * attResult >= 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result * attResult;
	}



	public List<BoardVo> selectBoardList(PageVo pvo) throws Exception{
		
//		비즈니스 로직 - 생략
		
//		DAO 호출
		Connection conn = getConnection();
		List<BoardVo> voList = dao.selectBoardList(conn, pvo);
		
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



	public int getBoardCnt() throws Exception {
//		비즈니스 로직 - x
		
//		SQL
		Connection conn = getConnection();
		int cnt = dao.getBoardCnt(conn);
		
		close(conn);
		
		return cnt;
	}



	public List<AttachmentVo> getAttachment(String no) throws Exception{
//		비즈니스 로직
		
//		SQL, DAO 호출
		Connection conn = getConnection();
		List<AttachmentVo> attVoList = dao.getAttachment(conn, no);
		
		close(conn);
		
		return attVoList; 
	}
	
	
	public int delete(String[] noArr) throws Exception{
		SqlSession ss = getSqlSession();
		int result = dao.delete(ss,noArr);
		
		if(result > 0) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}

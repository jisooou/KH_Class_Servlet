package com.kh.app.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardReplyDao;
import com.kh.app.board.vo.BoardReplyVo;
import static com.kh.app.db.SqlSessionTemplate.*;

public class BoardReplyService {
	
	private final BoardReplyDao dao;
	
	public BoardReplyService() {
		this.dao = new BoardReplyDao();
	}

	//댓글 작성
	public int writeReply(BoardReplyVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		int result = dao.writeReply(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}
	
	//댓글 목록조회
	public List<BoardReplyVo> getReplyAllByBoardNo(String refNo) throws Exception{
		SqlSession ss = getSqlSession();
		List<BoardReplyVo> replyVoList = dao.getReplyAllByBoardNo(ss, refNo);
		ss.close();
		return replyVoList;
	} 

}//class
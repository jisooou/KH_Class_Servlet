package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {
	
//	게시글 작성 
	public int insertBoard(SqlSession ss,BoardVo vo) throws Exception  {
		return ss.insert("BoardMapper.insertBoard", vo);
	}
	
	
//	게시글 목록 조회 
	public List<BoardVo> getBoardList(SqlSession ss) throws Exception{
		return ss.selectList("BoardMapper.selectBoardList");
	}

}

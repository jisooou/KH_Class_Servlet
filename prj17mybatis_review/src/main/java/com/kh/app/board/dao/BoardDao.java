package com.kh.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;

public class BoardDao {

	public int insertBoard(SqlSession ss, BoardVo vo) throws Exception{
		return ss.insert("BoardMapper.insertBoard", vo);
	}

	public List<BoardVo> getBoardList(SqlSession ss) throws Exception{
		return ss.selectList("BoardMapper.selectBoardList");
	}
	

}

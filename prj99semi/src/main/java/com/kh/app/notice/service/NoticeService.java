package com.kh.app.notice.service;

import static com.kh.app.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardReplyDao;
import com.kh.app.board.vo.BoardReplyVo;
import com.kh.app.board.vo.PageVo;
import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeVo;

public class NoticeService {
	
	private final NoticeDao dao;
	
	public NoticeService() {
		this.dao = new NoticeDao();
	}
	
//	작성
	public int write(NoticeVo vo) throws Exception{
		SqlSession ss = getSqlSession();
		int result = dao.write(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}
	
//	목록조회
	public List<NoticeVo> getNoticeList(PageVo pvo) throws Exception {
		SqlSession ss = getSqlSession();
		List<NoticeVo> noticeList = dao.getNoticeList(ss, pvo);
		ss.close();
		return noticeList;
	}
	
//	상세조회
	public NoticeVo getNotice(String no) throws Exception{
		SqlSession ss = getSqlSession();
		NoticeVo vo = dao.getNotice(ss, no);
		ss.close();
		return vo;
	}

//	공지사항 갯수 조회
	public int getNoticeCount() throws Exception{
		SqlSession ss = getSqlSession();
		int cnt = dao.getNoticeCount(ss);
		ss.close();
		return cnt;
	}

}

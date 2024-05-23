package com.kh.app.admin.service;

import static com.kh.app.db.JDBCTemplate.close;
import static com.kh.app.db.JDBCTemplate.commit;
import static com.kh.app.db.JDBCTemplate.getConnection;
import static com.kh.app.db.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.admin.vo.AdminVo;

public class AdminService {
	
	private final AdminDao dao;
	
	public AdminService() {
		this.dao = new AdminDao();
	}

	public AdminVo login(AdminVo vo) throws Exception {

//		비즈니스 로직
		
//		DAO호출
		Connection conn = getConnection();
		AdminVo loginAdminVo = dao.getAdminVo(conn, vo);
		
		close(conn);
		
		return loginAdminVo;
	}

}

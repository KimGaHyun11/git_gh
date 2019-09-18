package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icanman.dao.AdminDao;
import com.icanman.vo.AdminVo;
import com.icanman.vo.AllVo;

public class AdminService {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	CommonServiceSupport support = new CommonServiceSupport();

	public AdminService() {
		support = new CommonServiceSupport();

	}

	public AllVo adminList(int page) throws Exception {
		conn = support.getConnection();
		
		AllVo allVo = new AllVo();
		AdminDao dao = new AdminDao();
		List<AdminVo> adminList = new ArrayList<AdminVo>();
		try {
			allVo = dao.adminList(conn, page);
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			support.dbClose(conn, ps, rs);
		}
		return allVo;
	}

}

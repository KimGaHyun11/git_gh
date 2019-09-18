package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.icanman.dao.LoginDao;
import com.icanman.dao.ViewDao;
import com.icanman.vo.AllVo;
import com.opensymphony.xwork2.ActionContext;

public class ViewService {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	CommonServiceSupport support = new CommonServiceSupport();

	public ViewService() {
		support = new CommonServiceSupport();
	}

	public AllVo view(int empNo) throws Exception {
		AllVo allVo = new AllVo();		
		ViewDao dao = new ViewDao();
		
		conn = support.getConnection();
		try {
		allVo = dao.mainView(conn, empNo);
		allVo = dao.schoolView(conn, allVo);
		allVo = dao.certificationView(conn, allVo);
		allVo = dao.careerView(conn, allVo);
		allVo = dao.educationView(conn, allVo);
		for(int i = 0; i<allVo.getCertificationList().size();i++) {
			System.out.println("service:"+allVo.getCertificationList().get(i).getCertificationName());
		}
		
		for(int i = 0; i<allVo.getSchoolList().size();i++) {
			System.out.println("service:"+allVo.getSchoolList().get(i).getSchoolName());		
			}
		}catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			support.dbClose(conn, ps, rs);
		}
		return allVo;
	}


}

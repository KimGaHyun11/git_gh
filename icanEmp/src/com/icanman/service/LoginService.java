package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.icanman.dao.LoginDao;
import com.icanman.vo.MainVo;
import com.opensymphony.xwork2.ActionContext;

public class LoginService {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	CommonServiceSupport support = new CommonServiceSupport();

	public LoginService() {
		support = new CommonServiceSupport();
		

	}


	public MainVo login(int empNo) throws Exception {
		System.out.println("Service.login");
		
		conn = support.getConnection();
		
		LoginDao dao = new LoginDao();
		MainVo mainVo = new MainVo();
		
		try {
			mainVo = dao.login(conn, empNo);		
			
			
		} catch (Exception e) {	
			conn.rollback();
			e.printStackTrace();
			throw e;
			
		}finally {
			support.dbClose(conn, ps, rs);
				
		}		
		return mainVo;				
	}


}

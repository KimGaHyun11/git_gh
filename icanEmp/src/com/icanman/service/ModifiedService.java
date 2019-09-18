package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.icanman.dao.InputDao;
import com.icanman.dao.ModifiedDao;
import com.icanman.vo.AllVo;
import com.icanman.vo.MainVo;


public class ModifiedService {
	
	Connection conn;
	PreparedStatement ps;
	
	CommonServiceSupport support = new CommonServiceSupport();

	public ModifiedService() {
		support = new CommonServiceSupport();
	}


	public Map<String, String> modified(AllVo allVo, int adminEmpNo) throws Exception {	
			System.out.println("Service.modified");

		conn = support.getConnection();	
		
		ModifiedDao dao = new ModifiedDao();						
		Map<String, String> inputResult = new HashMap<String, String>();
		
		try {
			String name = dao.modified(conn, allVo, adminEmpNo);
			System.out.println("service : " + name);
			inputResult.put("name", name);
			
				String school = dao.schoolModified(conn, allVo);
				inputResult.put("school", school);	
			
				String career = dao.careerModified(conn, allVo);
				inputResult.put("career", career);	
		
				String certification = dao.certificationModified(conn, allVo);
				inputResult.put("certification", certification);	
		
				String education = dao.educationModified(conn, allVo);
				inputResult.put("education", education);	
		
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally {
			support.dbClose(conn, ps);
		}
		
		return inputResult;
		
	}
}

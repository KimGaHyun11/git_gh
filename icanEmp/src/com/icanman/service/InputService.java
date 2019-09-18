package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.icanman.dao.InputDao;
import com.icanman.vo.AllVo;
import com.icanman.vo.MainVo;


public class InputService {
	
	Connection conn;
	PreparedStatement ps;
	
	CommonServiceSupport support = new CommonServiceSupport();

	public InputService() {
		support = new CommonServiceSupport();
	}


	public Map<String, String> input(AllVo allVo, int adminEmpNo) throws Exception {	
			System.out.println("Service.input");

		conn = support.getConnection();
		
		InputDao dao = new InputDao();		
		String name = null;
		
		Map<String, String> inputResult = new HashMap<String, String>();
		
		try {
			name = dao.input(conn,allVo);
			inputResult.put("name", name);				
			dao.selectEmpNo(conn, allVo, adminEmpNo);  
			
			
			//값이 있을 때만 실행되도록
			if(!allVo.getSchoolList().get(0).getSchoolName().equals("")) {
				String school = dao.schoolInput(conn, allVo);
				inputResult.put("school", school);	
			}
			
			if(!allVo.getCertificationList().get(0).getCertificationName().equals("")) {
				String certification = dao.certificationInput(conn, allVo);
				inputResult.put("certification", certification);	
			}
			
			if(!allVo.getCareerList().get(0).getBeforeEmp().equals("")) {
				String career = dao.careerInput(conn, allVo);
				inputResult.put("career", career);	
			}
			
			if(!allVo.getEducationList().get(0).getInstitute().equals("")) {
				String education = dao.educationInput(conn, allVo);		
				inputResult.put("education", education);	
			}

			
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			support.dbClose(conn, ps);
		}
		
		return inputResult;
		
	}
}

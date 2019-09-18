package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icanman.vo.MainVo;

public class LoginDao {
	

	PreparedStatement ps = null;
	ResultSet rs = null;


	public MainVo login(Connection conn, int empNo) throws Exception {
		System.out.println("dao.login");
		MainVo mainVo = new MainVo();
		
		String sql = " select empNo, name, adminPw from main where empNo=? and stateY=0 and adminY=1 ";

		try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, empNo);
		rs = ps.executeQuery();

		if(rs.next()) {
			mainVo.setName(rs.getString("name"));
			mainVo.setAdminPw(rs.getString("adminPw"));			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mainVo;
	}

}

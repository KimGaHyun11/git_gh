package com.icanman.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonServiceSupport {
	
	
	
	
	public CommonServiceSupport() {
		try{
	    	 Class.forName("org.postgresql.Driver");	    	
	     }catch(Exception e){ e.printStackTrace(); }
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
		    			 "jdbc:postgresql://ec2-107-22-211-248.compute-1.amazonaws.com:5432/dd8u93qv6p4luh",
		    			 "jnfpmwwvodikng",
		    			 "35469c50093cb3101cf5ebd7400271c08ad1b337f3b8924479ad3af4ac371c93");
	}
	
	//DB연결 후 닫는 메소드(조회 시)
	public void dbClose(Connection conn, PreparedStatement ps, ResultSet rs) { 
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}

	}
	
	//DB연결 후 닫는 메소드(데이터변환 시)
	public void dbClose(Connection conn, PreparedStatement ps) { 
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}

	}

}

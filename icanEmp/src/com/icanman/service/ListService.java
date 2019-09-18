package com.icanman.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.icanman.dao.ListDao;
import com.icanman.vo.AllVo;

public class ListService {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	CommonServiceSupport support = new CommonServiceSupport();

	public ListService() {
		support = new CommonServiceSupport();

	}

	public AllVo list(Map<String, String> map, int page) throws Exception {
		System.out.println("Service.list");
		System.out.println("select : " + map.get("select") + ", search : " + map.get("search"));

		conn = support.getConnection();
		ListDao dao = new ListDao();
		AllVo allVo = new AllVo();
		
		try {
			allVo = dao.list(conn, map, page);

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

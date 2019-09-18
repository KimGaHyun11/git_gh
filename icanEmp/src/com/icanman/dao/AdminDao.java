package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icanman.vo.AdminVo;
import com.icanman.vo.AllVo;
import com.icanman.vo.PagingVo;

public class AdminDao {

	PreparedStatement ps;
	ResultSet rs;

	
	//활동이력 저장하는 메소드
	public void adminCheck(Connection conn, AllVo allVo, int empNo, String content) throws Exception {
	
		String sql = " insert into admin_record(num, empNo, objectEmpno, recordDay, recordContent)"
				+ "values (nextVal('admin_record_seq'), ?, ?, now(), ?) ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			ps.setInt(2, allVo.getMainVo().getEmpNo());
			ps.setString(3, content);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    //관리자 활동이력 리스트
	public AllVo adminList(Connection conn, int page) throws Exception{
		AllVo allVo = new AllVo();
		List<AdminVo> adminList = new ArrayList<AdminVo>();
		
		int total = getCount(conn);
		PagingDao pagingDao=  new PagingDao();
		PagingVo pagingVo = pagingDao.paging(conn, page, total);

		
		String sql = "select "
				+ "  a.empno, m.name as empName, a.objectempno, "
				+ "  (select name from main mm where mm.empno=a.objectempno) as objectName, "
				+ "  to_char(a.recordday, 'YYYY년 MM월 DD일 hh24시 mi분 ss초')as recordDay, "
				+ "  a.recordcontent "
				+ "  from admin_record a join main m on a.empno = m.empno "
				+ "  order by recordDay desc limit ? offset ? -1 ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pagingVo.getPageSize());
			ps.setInt(2, pagingVo.getStartNum());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AdminVo adminVo = new AdminVo();
				adminVo.setEmpNo(rs.getInt("empNo"));
				adminVo.setObjectEmpNo(rs.getInt("objectEmpNo"));
				adminVo.setRecordDay(rs.getString("recordDay"));
				adminVo.setRecordContent(rs.getString("recordContent"));
				adminVo.setEmpName(rs.getString("empName"));
				adminVo.setObjectName(rs.getString("objectName"));
				
				adminList.add(adminVo);
			}
			
			allVo.setPagingVo(pagingVo);
			allVo.setAdminList(adminList);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}	
		return allVo;
	}
	
	
	
	public int getCount(Connection conn) throws Exception{		
		int totalCount = 0;		
		String sql = "select count(*) as cnt from admin_record ";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt("cnt");
			}
			System.out.println("totalCount : " + totalCount);
			
		}catch(Exception e ) {
			e.printStackTrace();
			throw e;
		}
		
		return totalCount;
	}

}


package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icanman.vo.AllVo;
import com.icanman.vo.MainVo;
import com.icanman.vo.PagingVo;
import com.icanman.vo.VoChange;

public class ListDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	public AllVo list(Connection conn, Map<String, String> map, int page) throws Exception {

		AllVo allVo = new AllVo();
		List<MainVo> mainList = new ArrayList<MainVo>();
		
		String retiree = map.get("retiree");  //재직자만 조회 or 전체조회 값
		String select = map.get("select");  //검색조건
		String search = map.get("search");  //검색내용
		String deptSelect = map.get("deptSelect");
		String jobSelect = map.get("jobSelect");
		
		//페이징처리
		int total = getCount(conn, map);
		PagingDao pagingDao = new PagingDao();
		PagingVo pagingVo = pagingDao.paging(conn, page, total);
				
		String sql = null;		
		try {
			if(retiree.equals("reti") && !search.equals("")
					  || !deptSelect.equals("") || !jobSelect.equals("") ) { //재직자만 조회, 검색어 있을 시
				System.out.println("재직자조회&검색");
				sql = "  select empNo, name, phone, stateY, stateDate, dept, jobTitle from main "
					+ "  where stateY = 0 and "
					+  select + "::text like ? "
					+ "  order by jobTitle, dept, name limit ? offset ? -1  ";
				
				ps = conn.prepareStatement(sql);
				psSet(ps, select, deptSelect, jobSelect, search);	
				
				ps.setInt(2, pagingVo.getPageSize());
				ps.setInt(3, pagingVo.getStartNum());	
				
			}else if(!search.equals("") || !deptSelect.equals("") || !jobSelect.equals("") ) {  //전체조회, 검색어 있을 시
				System.out.println("전체조회&검색");
				sql = " select empNo, name, phone, stateY, stateDate, dept, jobTitle from main  where "
						+  select +  "::text like ? "
					+ " order by jobTitle, dept, name limit ? offset ? -1  ";
				
				ps = conn.prepareStatement(sql);
				psSet(ps, select, deptSelect, jobSelect, search);	
				
				ps.setInt(2, pagingVo.getPageSize());
				ps.setInt(3, pagingVo.getStartNum());	
				
			}else if(!retiree.equals("reti")) {  //전체조회만
				System.out.println("전체조회");
				sql = " select empNo, name, phone, stateY, stateDate, dept, jobTitle from main  "
					+ " order by jobTitle, dept, name limit ? offset ? -1  ";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pagingVo.getPageSize());
				ps.setInt(2, pagingVo.getStartNum());	
				
			
			
			}else {   //재직조회만
				System.out.println("재직자조회");
				sql = "   select empNo, name, phone, stateY, stateDate, dept, jobTitle from main "
					+ "   where stateY = 0  "
					+ "   order by jobTitle, dept, name limit ? offset ? -1 ";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, pagingVo.getPageSize());
				ps.setInt(2, pagingVo.getStartNum());			
			
			}
			
			
			rs = ps.executeQuery();
			System.out.println(ps);

			while (rs.next()) { //조회된 데이터가 있을 시 vo에 담아 list로 넣기	
				MainVo mainVo = new MainVo();
				mainVo.setEmpNo(rs.getInt("empNo"));
				mainVo.setName(rs.getString("name"));
				mainVo.setPhone(rs.getString("phone"));
				mainVo.setStateY(rs.getInt("stateY"));
				mainVo.setStateDate(rs.getString("stateDate"));
				mainVo.setDept(rs.getInt("dept"));
				mainVo.setJobTitle(rs.getInt("JobTitle"));

				//변환하여 출력해야 할 내용 변환하여 vo에 담기
				VoChange voChange = new VoChange();
				String stat = voChange.title(mainVo);
				String jobT = voChange.jobTitle(mainVo);
				String deptT = voChange.deptTitle(mainVo);

				mainVo.setState(stat);
				mainVo.setJobT(jobT);
				mainVo.setDeptT(deptT);

				mainList.add(mainVo);
			}
			allVo.setPagingVo(pagingVo);
			allVo.setMainList(mainList);
			
			for(MainVo v : allVo.getMainList()) {
				System.out.println(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}
	
	public void psSet(PreparedStatement ps, String select, String deptSelect, String jobSelect, String search) throws SQLException {
		
		try {
			if(select.equals("dept")){
				//ps.setString(1, select);
				ps.setString(1, "%"+deptSelect+"%");
				
			}else if(select.equals("jobTitle")) {
				//ps.setString(1, select);
				ps.setString(1, "%"+jobSelect+"%");
				
			}else {
				//ps.setString(1, select);
				ps.setString(1, "%"+search+"%");
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	

	//페이징 전체 페이지 수 
	public int getCount(Connection conn, Map<String, String> map) throws Exception {
		
		int totalCount = 0;
		String sql = null;
		String retiree = map.get("retiree");  //재직자만 조회 or 전체조회 값
		String select = map.get("select");  //검색조건
		String search = map.get("search");  //검색내용
		String deptSelect = map.get("deptSelect");
		String jobSelect = map.get("jobSelect");
		
		try {
			if(retiree.equals("reti") && !search.equals("")
					  || !deptSelect.equals("") || !jobSelect.equals("") ) { //재직자만 조회, 검색어 있을 시
				sql = "  select count(*) as cnt from main  "
					+ "  where stateY = 0 and "
					 +  select + "::text like ? ";				
				ps = conn.prepareStatement(sql);
				psSet(ps, select, deptSelect, jobSelect, search);	
			
				
			}else if(!search.equals("") || !deptSelect.equals("") || !jobSelect.equals("") ) {  //전체조회, 검색어 있을 시
				sql = "  select count(*) as cnt from main where "
					+  select +  "::text like ? ";				
				ps = conn.prepareStatement(sql);
				psSet(ps, select, deptSelect, jobSelect, search);	
			
			}else if(!retiree.equals("reti")) {  //전체조회
				sql = " select count(*) as cnt from main  ";				
				ps = conn.prepareStatement(sql);		
				
			}else {   //재직자조회만
				sql = " select count(*) as cnt from main  "
					+ " where stateY = 0  ";				
				ps = conn.prepareStatement(sql);
				
			}			
			rs = ps.executeQuery();
		
			
			if (rs.next()) {
				totalCount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return totalCount;
	}

}

package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icanman.vo.AllVo;
import com.icanman.vo.CareerVo;
import com.icanman.vo.CertificationVo;
import com.icanman.vo.EducationVo;
import com.icanman.vo.SchoolVo;

public class InputDao {
	PreparedStatement ps = null;
	ResultSet rs = null;

	//메인 입력
	public String input(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.input");
		String name = null;
		String sql = null;

		sql = " insert into main(empno, name, residentNum, hiredate, "
				+ "     phone, email, dept, jobTitle, skillcode, skillgrade, skill, statey, adminy) "
				+ "    values(nextVal('main_seq'), ?, ?, ?, " 
				+ "      ?, ?, ?, ?, ?, ?, ?, 0 , 0 ) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, allVo.getMainVo().getName());
			ps.setString(2, allVo.getMainVo().getResidentNum());
			ps.setString(3, allVo.getMainVo().getHiredate());
			ps.setString(4, allVo.getMainVo().getPhone());
			ps.setString(5, allVo.getMainVo().getEmail());
			ps.setInt(6, allVo.getMainVo().getDept());
			ps.setInt(7, allVo.getMainVo().getJobTitle());
			ps.setString(8, allVo.getMainVo().getSkillCode());
			ps.setString(9, allVo.getMainVo().getSkillGrade());
			ps.setString(10, allVo.getMainVo().getSkill());
			ps.executeUpdate();

			name = allVo.getMainVo().getName();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return name;
	}

	//메인에 입력된 정보에 empNo 꺼내오기(다른 테이블의 fk)
	public AllVo selectEmpNo(Connection conn, AllVo allVo, int adminEmpNo) throws Exception {
		String sql = "select empNo from main where name = ? and residentNum = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, allVo.getMainVo().getName());
			ps.setString(2, allVo.getMainVo().getResidentNum());
			rs = ps.executeQuery();

			while (rs.next()) {
				allVo.getMainVo().setEmpNo(rs.getInt("empNo"));
			}
			AdminDao adminDao = new AdminDao();
			adminDao.adminCheck(conn, allVo, adminEmpNo, "정보입력");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

	//학교정보 입력
	public String schoolInput(Connection conn, AllVo allVo) throws Exception {
		String school = null;
		String sql = " insert into school(num, empNo, startday, endDay, schoolName, major, frontdelete) "
				+ "      values(nextVal('school_seq'), ?, ?, ?, ?, ?, 0) ";

		try {
			for (int no = 0; no < allVo.getSchoolList().size(); no++) {
				if (allVo.getSchoolList().get(no) != null) {
					SchoolVo scVo = allVo.getSchoolList().get(no);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, allVo.getMainVo().getEmpNo());
					ps.setString(2, scVo.getStartDay());
					ps.setString(3, scVo.getEndDay());
					ps.setString(4, scVo.getSchoolName());
					ps.setString(5, scVo.getMajor());
					ps.executeUpdate();
				}
			}

			school = "school";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return school;
	}

	//자격증정보 입력
	public String certificationInput(Connection conn, AllVo allVo) throws Exception {

		String certification = null;
		String sql = " insert into certification(num, empNo, certificationName, acpdate, agency, frontdelete) "
				+ "      values(nextVal('certification_seq'), ?, ?, ?, ?, 0) ";

		try {

			for (int no = 0; no < allVo.getCertificationList().size(); no++) {
				if (allVo.getCertificationList().get(no) != null) {
					CertificationVo ceVo = allVo.getCertificationList().get(no);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, allVo.getMainVo().getEmpNo());
					ps.setString(2, ceVo.getCertificationName());
					ps.setString(3, ceVo.getAcpDate());
					ps.setString(4, ceVo.getAgency());
					ps.executeUpdate();
				}
			}
			

			certification = "certification";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return certification;
	}

	//경력정보 입력
	public String careerInput(Connection conn, AllVo allVo) throws Exception {

		String career = null;
		String sql = " insert into career(num, empNo, beforeEmp, startDay, "
				+ "      endDay, title, beforework, retirement, frontdelete) "
				+ "      values(nextVal('career_seq'), ?, ?, ?, ?, ?, ?, ?, 0) ";

		try {

			for (int no = 0; no < allVo.getCareerList().size(); no++) {
				if (allVo.getCareerList().get(no) != null) {
					CareerVo caVo = allVo.getCareerList().get(no);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, allVo.getMainVo().getEmpNo());
					ps.setString(2, caVo.getBeforeEmp());
					ps.setString(3, caVo.getStartDay());
					ps.setString(4, caVo.getEndDay());
					ps.setString(5, caVo.getTitle());
					ps.setString(6, caVo.getBeforeWork());
					ps.setString(7, caVo.getRetirement());

					ps.executeUpdate();

				}
			}

			career = "career";
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return career;
	}

	//교육정보 입력
	public String educationInput(Connection conn, AllVo allVo) throws Exception {

		String education = null;
		String sql = " insert into education(num, empNo, institute, startDay, endDay, content, frontdelete) "
				+ "      values(nextVal('education_seq'), ?, ?, ?, ?, ?, 0) ";

		try {

			for (int no = 0; no < allVo.getEducationList().size(); no++) {
				if (allVo.getEducationList().get(no) != null) {
					EducationVo eduVo = allVo.getEducationList().get(no);
					ps = conn.prepareStatement(sql);
					ps.setInt(1, allVo.getMainVo().getEmpNo());
					ps.setString(2, eduVo.getInstitute());
					ps.setString(3, eduVo.getStartDay());
					ps.setString(4, eduVo.getEndDay());
					ps.setString(5, eduVo.getContent());
					ps.executeUpdate();
				}
			}

			education = "education";
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return education;
	}
}

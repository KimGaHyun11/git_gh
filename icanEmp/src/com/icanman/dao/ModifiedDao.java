package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icanman.vo.AllVo;
import com.icanman.vo.CareerVo;
import com.icanman.vo.CertificationVo;
import com.icanman.vo.EducationVo;
import com.icanman.vo.SchoolVo;

public class ModifiedDao {
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String modified(Connection conn, AllVo allVo, int adminEmpNo) throws Exception {
		System.out.println("메인수정");
		String name = null;

		String sql = "update main set "
		        + "  name=?, residentNum=?, hiredate=?, phone=?, email=?, dept=?, jobTitle=?, "
				+ "  skillCode=?, skillGrade=?, skill=?, stateY=?, stateDate=?, adminY=?, adminPw=? "
				+ "  where empno=? ";

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
			ps.setInt(11, allVo.getMainVo().getStateY());
			ps.setString(12, allVo.getMainVo().getStateDate());
			ps.setInt(13, allVo.getMainVo().getAdminY());
			ps.setString(14, allVo.getMainVo().getAdminPw());
			
			ps.setInt(15, allVo.getMainVo().getEmpNo());
			ps.executeUpdate();

			name = allVo.getMainVo().getName();
			
			AdminDao adminDao = new AdminDao();
			adminDao.adminCheck(conn, allVo, adminEmpNo, "정보수정");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return name;
	}

	public List<Integer> selectNum(String search, Connection conn, AllVo allVo) {

		String sql = "select num from " + search + " where empNo = ? ";

		List<Integer> numList = new ArrayList<Integer>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, allVo.getMainVo().getEmpNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				numList.add(rs.getInt("num"));
			}

			for (int num : numList) {
				System.out.println("num : " + num);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return numList;
	}

	//학교정보 입력
	public String schoolModified(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.schoolmodified");
		SchoolVo scVo = new SchoolVo();
		String school = null; //결과값
		String sql = null;
		int choice = 0; //수정, 추가, 삭제 판별할 변수

		try {
			List<SchoolVo> sList = new ArrayList<SchoolVo>();
			sList = allVo.getSchoolList();

			if (sList != null) {
				for (int i = 0; i < sList.size(); i++) {
					if (sList.get(i).getSchoolName() == null || sList.get(i).getSchoolName() == "") {
						choice = 3;
					} else if (sList.get(i).getNum() == 0) {
						choice = 2;
					} else {
						choice = 1;
					}

					switch (choice) {
					case 1: //수정
						sql = " update school set startDay = ?, endDay = ?, schoolName = ?, major = ? "
								+ "   where num = ? and empNo = ? ";
						System.out.println("수정");
						scVo = sList.get(i);
						ps = conn.prepareStatement(sql);

						ps.setString(1, scVo.getStartDay());
						ps.setString(2, scVo.getEndDay());
						ps.setString(3, scVo.getSchoolName());
						ps.setString(4, scVo.getMajor());
						ps.setInt(5, scVo.getNum());
						ps.setInt(6, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;

					case 2: //추가
						sql = " insert into school(num, empNo, startday, endDay, schoolName, major) "
								+ "      values(nextVal('school_seq'), ?, ?, ?, ?, ?) ";

						System.out.println("추가");
						scVo = sList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, allVo.getMainVo().getEmpNo());
						ps.setString(2, scVo.getStartDay());
						ps.setString(3, scVo.getEndDay());
						ps.setString(4, scVo.getSchoolName());
						ps.setString(5, scVo.getMajor());
						ps.executeUpdate();
						break;
					case 3:
						//sql = " delete from school where num = ? and empNo = ?  ";
						sql = "update school set frontdelete = 1 where num = ? and empNo = ? ";
						System.out.println("삭제");
						scVo = sList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, scVo.getNum());
						ps.setInt(2, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;
					}
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
	public String certificationModified(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.certificationModified");
		CertificationVo certificationVo = new CertificationVo();
		String certification = null; //결과값
		String sql = null;
		int choice = 0; //수정, 추가, 삭제 판별할 변수

		try {
			List<CertificationVo> certificationList = new ArrayList<CertificationVo>();
			certificationList = allVo.getCertificationList();

			if (certificationList != null) {
				for (int i = 0; i < certificationList.size(); i++) {
					if (certificationList.get(i).getCertificationName() == null
							|| certificationList.get(i).getCertificationName() == "") {
						choice = 3;
					} else if (certificationList.get(i).getNum() == 0) {
						choice = 2;
					} else {
						choice = 1;
					}

					switch (choice) {
					case 1: //수정
						sql = " update certification set certificationName = ?, acpdate = ?, agency = ? "
								+ "   where num = ? and empNo = ? ";
						System.out.println("수정");
						certificationVo = certificationList.get(i);
						ps = conn.prepareStatement(sql);

						ps.setString(1, certificationVo.getCertificationName());
						ps.setString(2, certificationVo.getAcpDate());
						ps.setString(3, certificationVo.getAgency());
						ps.setInt(4, certificationVo.getNum());
						ps.setInt(5, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;

					case 2: //추가
						sql = " insert into certification(num, empNo, certificationName, acpdate, agency) "
								+ "      values(nextVal('school_seq'), ?, ?, ?, ?) ";
						System.out.println("추가");
						certificationVo = certificationList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, allVo.getMainVo().getEmpNo());
						ps.setString(2, certificationVo.getCertificationName());
						ps.setString(3, certificationVo.getAcpDate());
						ps.setString(4, certificationVo.getAgency());
						ps.executeUpdate();
						break;
					case 3:
						//sql = " delete from certification where num = ? and empNo = ?  ";
						sql = "update certification set frontdelete = 1 where num = ? and empNo = ? ";
						System.out.println("삭제");
						certificationVo = certificationList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, certificationVo.getNum());
						ps.setInt(2, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();

						break;
					}
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
	public String careerModified(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.careerModified");
		CareerVo careerVo = new CareerVo();

		String career = null; //결과값
		String sql = null;
		int choice = 0; //수정, 추가, 삭제 판별할 변수

		try {
			List<CareerVo> careerList = new ArrayList<CareerVo>();
			careerList = allVo.getCareerList();

			if (careerList != null) {
				for (int i = 0; i < careerList.size(); i++) {
					if (careerList.get(i).getBeforeEmp() == null || careerList.get(i).getBeforeEmp() == "") {
						choice = 3;
					} else if (careerList.get(i).getNum() == 0) {
						choice = 2;
					} else {
						choice = 1;
					}

					switch (choice) {
					case 1: //수정
						sql = " update career set beforeEmp = ?, startDay = ?, endDay = ?, "
								+ "   title = ?, beforeWork = ?, retirement = ? " + "   where num = ? and empNo = ? ";
						System.out.println("수정");
						careerVo = careerList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setString(1, careerVo.getBeforeEmp());
						ps.setString(2, careerVo.getStartDay());
						ps.setString(3, careerVo.getEndDay());
						ps.setString(4, careerVo.getTitle());
						ps.setString(5, careerVo.getBeforeWork());
						ps.setString(6, careerVo.getRetirement());
						ps.setInt(7, careerVo.getNum());
						ps.setInt(8, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;

					case 2: //추가
						sql = " insert into career(num, empNo, beforeEmp, "
								+ "startday, endDay, title, beforework, retirement) "
								+ "      values(nextVal('school_seq'), ?, ?, ?, ?, ?, ?, ?) ";
						System.out.println("추가");
						careerVo = careerList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, allVo.getMainVo().getEmpNo());
						ps.setString(2, careerVo.getBeforeEmp());
						ps.setString(3, careerVo.getStartDay());
						ps.setString(4, careerVo.getEndDay());
						ps.setString(5, careerVo.getTitle());
						ps.setString(6, careerVo.getBeforeWork());
						ps.setString(7, careerVo.getRetirement());
						ps.executeUpdate();
						break;
					case 3:
						//sql = " delete from career where num = ? and empNo = ?  ";
						sql = "update career set frontdelete = 1 where num = ? and empNo = ? ";
						System.out.println("삭제");
						careerVo = careerList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, careerVo.getNum());
						ps.setInt(2, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;
					}
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
	public String educationModified(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.educationModified");
		EducationVo educationVo = new EducationVo();
		String education = null; //결과값
		String sql = null;
		int choice = 0; //수정, 추가, 삭제 판별할 변수

		try {
			List<EducationVo> educationList = new ArrayList<EducationVo>();
			educationList = allVo.getEducationList();

			if (educationList != null) {
				for (int i = 0; i < educationList.size(); i++) {
					if (educationList.get(i).getInstitute() == null || educationList.get(i).getInstitute() == "") {
						choice = 3;
					} else if (educationList.get(i).getNum() == 0) {
						choice = 2;
					} else {
						choice = 1;
					}

					switch (choice) {
					case 1: //수정
						sql = " update education set institute =?, startDay=?, endDay=?, content= ?"
								+ " where num = ? and empNo = ? ";
						System.out.println("수정");
						educationVo = educationList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setString(1, educationVo.getInstitute());
						ps.setString(2, educationVo.getStartDay());
						ps.setString(3, educationVo.getEndDay());
						ps.setString(4, educationVo.getContent());
						ps.setInt(5, educationVo.getNum());
						ps.setInt(6, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;

					case 2: //추가
						sql = " insert into education(num, empNo, institute, startDay, endDay, content) "
								+ "      values(nextVal('school_seq'), ?, ?, ?, ?, ?) ";
						System.out.println("추가");
						educationVo = educationList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, allVo.getMainVo().getEmpNo());
						ps.setString(2, educationVo.getInstitute());
						ps.setString(3, educationVo.getStartDay());
						ps.setString(4, educationVo.getEndDay());
						ps.setString(5, educationVo.getContent());
						ps.executeUpdate();
						break;
					case 3:
						//sql = " delete from education where num = ? and empNo = ?  ";
						sql = "update education set frontdelete = 1 where num = ? and empNo = ? ";
						System.out.println("삭제");
						educationVo = educationList.get(i);
						ps = conn.prepareStatement(sql);
						ps.setInt(1, educationVo.getNum());
						ps.setInt(2, allVo.getMainVo().getEmpNo());
						ps.executeUpdate();
						break;
					}
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

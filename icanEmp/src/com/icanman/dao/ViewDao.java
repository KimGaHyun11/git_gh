package com.icanman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.icanman.vo.AllVo;
import com.icanman.vo.CareerVo;
import com.icanman.vo.CertificationVo;
import com.icanman.vo.EducationVo;
import com.icanman.vo.MainVo;
import com.icanman.vo.SchoolVo;
import com.icanman.vo.VoChange;

public class ViewDao {

	PreparedStatement ps;
	ResultSet rs;

	public AllVo mainView(Connection conn, int empNo) throws Exception {
		System.out.println("dao.mainView");
		AllVo allVo = new AllVo();
		MainVo mainVo = new MainVo();
		String sql = "select empNo, name, residentNum, hiredate, phone, email, "
				+ "   dept, jobTitle, skillCode, skillgrade, skill, " + "   stateY, stateDate, adminy, adminPw "
				+ "   from main " + "   where empNo = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				mainVo.setEmpNo(rs.getInt("empNo"));
				mainVo.setName(rs.getString("name"));
				mainVo.setResidentNum(rs.getString("residentNum"));
				mainVo.setHiredate(rs.getString("hiredate"));
				mainVo.setPhone(rs.getString("phone"));
				mainVo.setEmail(rs.getString("email"));
				mainVo.setDept(rs.getInt("dept")); //
				mainVo.setJobTitle(rs.getInt("jobTitle")); //
				mainVo.setSkillCode(rs.getString("skillCode"));
				mainVo.setSkillGrade(rs.getString("skillGrade"));
				mainVo.setSkill(rs.getString("skill"));
				mainVo.setStateY(rs.getInt("stateY")); //
				mainVo.setStateDate(rs.getString("stateDate")); //
				mainVo.setAdminY(rs.getInt("adminY"));
				mainVo.setAdminPw(rs.getString("adminPw"));

				VoChange voChange = new VoChange();
				String stat = voChange.title(mainVo);

				if (stat.equals("")) {
					stat = "재직";
				}

				String jobT = voChange.jobTitle(mainVo);
				String deptT = voChange.deptTitle(mainVo);

				mainVo.setState(stat);
				mainVo.setJobT(jobT);
				mainVo.setDeptT(deptT);

				System.out.println(mainVo.toString());
				allVo.setMainVo(mainVo);
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

	//학력
	public AllVo schoolView(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.schoolView");
		SchoolVo scVo = new SchoolVo();
		List<SchoolVo> scList = new ArrayList<SchoolVo>();

		String sql = " select num, startDay, endDay, schoolName, major " + "    from school " + "    where empNo = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, allVo.getMainVo().getEmpNo());
			rs = ps.executeQuery();

			while (rs.next()) {

				scVo = new SchoolVo();
				scVo.setNum(rs.getInt("num"));
				scVo.setStartDay(rs.getString("startDay"));
				scVo.setEndDay(rs.getString("endDay"));
				scVo.setSchoolName(rs.getString("schoolName"));
				scVo.setMajor(rs.getString("major"));

				scList.add(scVo);
			}
			allVo.setSchoolList(scList);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

	//자격증
	public AllVo certificationView(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.certificationView");

		CertificationVo cerVo = new CertificationVo();
		List<CertificationVo> cerList = new ArrayList<CertificationVo>();
		String sql = " select " + "    num, certificationName, acpDate, agency " + "    from Certification "
				+ "    where empno = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, allVo.getMainVo().getEmpNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				cerVo = new CertificationVo();
				cerVo.setNum(rs.getInt("num"));
				cerVo.setCertificationName(rs.getString("certificationName"));
				cerVo.setAcpDate(rs.getString("acpDate"));
				cerVo.setAgency(rs.getString("agency"));
				cerList.add(cerVo);
			}
			allVo.setCertificationList(cerList);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

	//경력
	public AllVo careerView(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.careerView");
		CareerVo carVo = new CareerVo();
		List<CareerVo> carList = new ArrayList<CareerVo>();
		String sql = " select num,  beforeEmp, startday, endDay, title, beforework, retirement " + "    from career "
				+ "    where empno = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, allVo.getMainVo().getEmpNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				carVo = new CareerVo();
				carVo.setNum(rs.getInt("num"));
				carVo.setBeforeEmp(rs.getString("beforeEmp"));
				carVo.setStartDay(rs.getString("startDay"));
				carVo.setEndDay(rs.getString("endDay"));
				carVo.setTitle(rs.getString("title"));
				carVo.setBeforeWork(rs.getString("beforework"));
				carVo.setRetirement(rs.getString("retirement"));

				carList.add(carVo);
			}
			allVo.setCareerList(carList);

			if (carList != null ) {

				int months = 0;
				for (int num = 0; num < carList.size(); num++) {
					if (carList.get(num).getStartDay() != null && carList.get(num).getEndDay() != null
							|| carList.get(num).getStartDay() != "" && carList.get(num).getEndDay() != "") {
						System.out.println(
								"term : " + carList.get(num).getStartDay() + ", " + carList.get(num).getEndDay());

						LocalDate startDay = LocalDate.parse(carList.get(num).getStartDay());
						LocalDate endDay = LocalDate.parse(carList.get(num).getEndDay());
						Long month = ChronoUnit.DAYS.between(startDay, endDay);

						months += month;
					}
				}
				System.out.println("months : " + months);

				if (months > 0) {
					allVo.getMainVo().setCarYearTerm(months / 365);
					allVo.getMainVo().setCarMonthTerm((months%365)/28);
					allVo.getMainVo().setCarWeekTerm(((months%365)%28)/7);
					System.out.println("년 : " + allVo.getMainVo().getCarYearTerm());
					System.out.println("월 : " + allVo.getMainVo().getCarMonthTerm());
					System.out.println("주 : " + allVo.getMainVo().getCarWeekTerm());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

	//교육
	public AllVo educationView(Connection conn, AllVo allVo) throws Exception {
		System.out.println("dao.educationView");

		EducationVo eduVo = new EducationVo();
		List<EducationVo> eduList = new ArrayList<EducationVo>();
		String sql = " select num, institute, startDay, endDay, content " + "    from education "
				+ "    where empNo = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, allVo.getMainVo().getEmpNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				eduVo = new EducationVo();
				eduVo.setNum(rs.getInt("num"));
				eduVo.setInstitute(rs.getString("institute"));
				eduVo.setStartDay(rs.getString("startDay"));
				eduVo.setEndDay(rs.getString("endDay"));
				eduVo.setContent(rs.getString("content"));

				eduList.add(eduVo);
			}

			allVo.setEducationList(eduList);

			if (eduList != null ) {
				int months = 0;
				for (int num = 0; num < eduList.size(); num++) {
					if (eduList.get(num).getStartDay() != null && eduList.get(num).getEndDay() != null
							|| eduList.get(num).getStartDay() != "" && eduList.get(num).getEndDay() != "") {
						System.out.println(
								"term : " + eduList.get(num).getStartDay() + ", " + eduList.get(num).getEndDay());

						LocalDate startDay = LocalDate.parse(eduList.get(num).getStartDay());
						LocalDate endDay = LocalDate.parse(eduList.get(num).getEndDay());
						Long month = ChronoUnit.DAYS.between(startDay, endDay);

						months += month;
					}
				}
				System.out.println("months : " + months);

				if (months > 0) {
				allVo.getMainVo().setEduYearTerm(months / 365);
				allVo.getMainVo().setEduMonthTerm((months % 365) / 28);
				allVo.getMainVo().setEduWeekTerm(((months%365)%28)/7);
				System.out.println("년 : " + allVo.getMainVo().getEduYearTerm());
				System.out.println("월 : " + allVo.getMainVo().getEduMonthTerm());
				System.out.println("주 : " + allVo.getMainVo().getEduWeekTerm());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return allVo;
	}

}

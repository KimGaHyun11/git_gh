package com.icanman.vo;

public class SchoolVo{ //학력사항

	private int num;  //구분번호
	private int empNo;  //사원번호(참조키)
	private String startDay; //시작일자
	private String endDay;  //마지막일자	
	private String schoolName;  //학교명
	private String major; //전공
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "SchoolVo [num=" + num + ", empNo=" + empNo + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", schoolName=" + schoolName + ", major=" + major + "]";
	}
	

	
	
}

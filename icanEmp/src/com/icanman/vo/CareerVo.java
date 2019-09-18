package com.icanman.vo;

public class CareerVo {  //경력사항
	
	private int num;  //구분번호
	private int empNo;  //사원번호(참조키)
	private String beforeEmp;  //전직장명
	private String startDay; //시작일자
	private String endDay; //마지막일자
	private String title; //직책
	private String beforeWork;  //업무
	private String retirement;  //퇴직사유

	
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
	public String getBeforeEmp() {
		return beforeEmp;
	}
	public void setBeforeEmp(String beforeEmp) {
		this.beforeEmp = beforeEmp;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBeforeWork() {
		return beforeWork;
	}
	public void setBeforeWork(String beforeWork) {
		this.beforeWork = beforeWork;
	}
	public String getRetirement() {
		return retirement;
	}
	public void setRetirement(String retirement) {
		this.retirement = retirement;
	}
	@Override
	public String toString() {
		return "CareerVo [num=" + num + ", empNo=" + empNo + ", beforeEmp=" + beforeEmp + ", startDay=" + startDay
				+ ", endDay=" + endDay + ", title=" + title + ", beforeWork=" + beforeWork + ", retirement="
				+ retirement + "]";
	}
	
	
	
}

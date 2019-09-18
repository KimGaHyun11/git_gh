package com.icanman.vo;

public class AdminVo {  //관리자
	
	private int num;  //구분번호
	private int empNo;  //사원번호(참조키)
	private int objectEmpNo; //수정된 사원번호	
	private String recordDay; //수정시간
	private String recordContent; //수정내용(삽입, 수정)
	
	private String empName;
	private String objectName;
	
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
	public int getObjectEmpNo() {
		return objectEmpNo;
	}
	public void setObjectEmpNo(int objectEmpNo) {
		this.objectEmpNo = objectEmpNo;
	}
	public String getRecordDay() {
		return recordDay;
	}
	public void setRecordDay(String recordDay) {
		this.recordDay = recordDay;
	}
	public String getRecordContent() {
		return recordContent;
	}
	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	@Override
	public String toString() {
		return "AdminVo [num=" + num + ", empNo=" + empNo + ", objectEmpNo=" + objectEmpNo + ", recordDay=" + recordDay
				+ ", recordContent=" + recordContent + ", empName=" + empName + ", objectName=" + objectName + "]";
	}
	
	
	
	
	
}

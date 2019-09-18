package com.icanman.vo;

import java.util.Date;

public class CertificationVo {  //자격증
	
	private int num;  //구분번호
	private int empNo;  //사원번호
	private String certificationName;  //자격증명
	private String acpDate;  //취득일자
	private String agency;  //발행기관


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
	public String getCertificationName() {
		return certificationName;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	public String getAcpDate() {
		return acpDate;
	}
	public void setAcpDate(String acpDate) {
		this.acpDate = acpDate;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	

}

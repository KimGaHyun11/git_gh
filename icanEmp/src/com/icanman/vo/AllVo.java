package com.icanman.vo;

import java.util.List;

public class AllVo {
	
	private MainVo mainVo;	
	private List<SchoolVo> schoolList;
	private List<CertificationVo> certificationList;
	private List<CareerVo> careerList;
	private List<EducationVo> educationList;
	
	private List<MainVo> mainList; 
	private PagingVo pagingVo;
	
	private List<AdminVo> adminList;
	
	
	public AllVo() {}
	
	
	
	public MainVo getMainVo() {
		return mainVo;
	}
	public void setMainVo(MainVo mainVo) {
		this.mainVo = mainVo;
	}
	public List<SchoolVo> getSchoolList() {
		return schoolList;
	}
	public void setSchoolList(List<SchoolVo> schoolList) {
		this.schoolList = schoolList;
	}
	public List<CertificationVo> getCertificationList() {
		return certificationList;
	}
	public void setCertificationList(List<CertificationVo> certificationList) {
		this.certificationList = certificationList;
	}
	public List<CareerVo> getCareerList() {
		return careerList;
	}
	public void setCareerList(List<CareerVo> careerList) {
		this.careerList = careerList;
	}
	public List<EducationVo> getEducationList() {
		return educationList;
	}
	public void setEducationList(List<EducationVo> educationList) {
		this.educationList = educationList;
	}


	public List<MainVo> getMainList() {
		return mainList;
	}


	public void setMainList(List<MainVo> mainList) {
		this.mainList = mainList;
	}


	public PagingVo getPagingVo() {
		return pagingVo;
	}


	public void setPagingVo(PagingVo pagingVo) {
		this.pagingVo = pagingVo;
	}



	public List<AdminVo> getAdminList() {
		return adminList;
	}



	public void setAdminList(List<AdminVo> adminList) {
		this.adminList = adminList;
	}

	@Override
	public String toString() {
		return "AllVo [mainVo=" + mainVo + ", schoolList=" + schoolList + ", certificationList=" + certificationList
				+ ", careerList=" + careerList + ", educationList=" + educationList + ", mainList=" + mainList
				+ ", pagingVo=" + pagingVo + ", adminList=" + adminList + "]";
	}

}

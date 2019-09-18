package com.icanman.action;

import java.util.List;

import com.icanman.service.ViewService;
import com.icanman.vo.AllVo;
import com.icanman.vo.CareerVo;
import com.icanman.vo.CertificationVo;
import com.icanman.vo.EducationVo;
import com.icanman.vo.MainVo;
import com.icanman.vo.SchoolVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ViewAction implements Action {

	private int empNo;

	private AllVo allVo;
	private MainVo mainVo;
	private List<SchoolVo> schoolList;
	private List<CertificationVo> certificationList;
	private List<CareerVo> careerList;
	private List<EducationVo> educationList;
	private String phoneM;

	@Override
	public String execute() throws Exception {
		System.out.println("empNo : " + empNo);

		

		ViewService service = new ViewService();
		allVo = service.view(empNo);

		mainVo = allVo.getMainVo();
		certificationList = allVo.getCertificationList();
		schoolList = allVo.getSchoolList();
		careerList = allVo.getCareerList();
		educationList = allVo.getEducationList();

		return "view";
	}

	public String getPhoneM() {
		return phoneM;
	}

	public void setPhoneM(String phoneM) {
		this.phoneM = phoneM;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public AllVo getAllVo() {
		return allVo;
	}

	public void setAllVo(AllVo allVo) {
		this.allVo = allVo;
	}

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

}

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

public class ModifyAction implements Action{
	
	private int empNo;
	
	private AllVo allVo;
	private MainVo mainVo;	
	private List<SchoolVo> schoolList;
	private List<CertificationVo> certificationList;
	private List<CareerVo> careerList;
	private List<EducationVo> educationList;
	private String jumin1;
	private String jumin2;
	private String email1;
	private String email2 = "";
	private String phone1;
	private String phone2;
	private String phone3;
	private int schoolSize;
	private int careerSize;
	private int educationSize;
	private int certificationSize;


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
		
		schoolSize = schoolList.size();
		careerSize = careerList.size();
		educationSize = educationList.size();
		certificationSize = certificationList.size();
		
		String[] jumin = mainVo.getResidentNum().split("-");
		jumin1 = jumin[0];
		jumin2 = jumin[1];
		
		String[] email = mainVo.getEmail().split("@");
		email1 = email[0];
		email2 = email[1];
		
		String[] phone = mainVo.getPhone().split("-");
		phone1 = phone[0];
		phone2 = phone[1];
		phone3 = phone[2];
	
		return "modify";
	}


	

	public int getCareerSize() {
		return careerSize;
	}




	public void setCareerSize(int careerSize) {
		this.careerSize = careerSize;
	}




	public int getEducationSize() {
		return educationSize;
	}




	public void setEducationSize(int educationSize) {
		this.educationSize = educationSize;
	}




	public int getCertificationSize() {
		return certificationSize;
	}




	public void setCertificationSize(int certificationSize) {
		this.certificationSize = certificationSize;
	}




	public int getSchoolSize() {
		return schoolSize;
	}




	public void setSchoolSize(int schoolSize) {
		this.schoolSize = schoolSize;
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



	public String getJumin1() {
		return jumin1;
	}



	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}



	public String getJumin2() {
		return jumin2;
	}



	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}



	public String getEmail1() {
		return email1;
	}



	public void setEmail1(String email1) {
		this.email1 = email1;
	}



	public String getEmail2() {
		return email2;
	}



	public void setEmail2(String email2) {
		this.email2 = email2;
	}



	public String getPhone1() {
		return phone1;
	}



	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}



	public String getPhone2() {
		return phone2;
	}



	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}



	public String getPhone3() {
		return phone3;
	}



	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	
	
	
	

}


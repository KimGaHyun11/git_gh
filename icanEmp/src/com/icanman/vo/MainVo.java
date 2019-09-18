package com.icanman.vo;

public class MainVo {  //메인
	
	
	private int empNo;  //사원번호, 시퀀스
	private String name;  //사원명
	private String residentNum;   //주민번호
	private String hiredate;  //입사일
	private String phone;  //연락처
	private String email;  //이메일
	private int dept;  //부서 (1:총괄 / 2:관리 / 3:개발 등등)
	private int jobTitle;  //직책 (1:사장/ 2:전무 / 3: 실장 등등)
	private String skillCode; //스킬코드
	private String skillGrade;  //스킨등급
	private String skill;  //보유스킬
	private int stateY;  //상태 (0:재직 / 1:휴직 / 2:퇴직 )
	private String stateDate;  //상태일자(state가 0이 아닌경우만 작성)
	private int adminY;  //관리자여부 (1:관리자 )
	private String adminPw;   //admin 1 일경우 암호
	
	private String jobT; //직책 문자변환
	private String deptT;  //부서 문자변환
	private String state;  //리스트상태표시
	private MainVo mainVo;

	//페이징
	private int page;
	private int startNum;
	private int endNum;
	private int recordCount;
	private int pageCount;
	private int pageSize;
	private int blockSize;
	private int startPage;
	private int endPage;
	private int endP;
	
	//view 기간
	private int eduYearTerm;
	private int eduMonthTerm;
	private int eduWeekTerm;
	private int carYearTerm;
	private int carMonthTerm;
	private int carWeekTerm;
	
	public int getEndP() {
		return endP;
	}
	public void setEndP(int endP) {
		this.endP = endP;
	}
	
	public MainVo() {}
    public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResidentNum() {
		return residentNum;
	}
	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getSkillCode() {
		return skillCode;
	}
	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}
	public String getSkillGrade() {
		return skillGrade;
	}
	public void setSkillGrade(String skillGrade) {
		this.skillGrade = skillGrade;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getStateY() {
		return stateY;
	}
	public void setStateY(int stateY) {
		this.stateY = stateY;
	}
	public String getStateDate() {
		return stateDate;
	}
	public void setStateDate(String stateDate) {
		this.stateDate = stateDate;
	}
	public int getAdminY() {
		return adminY;
	}
	public void setAdminY(int adminY) {
		this.adminY = adminY;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getJobT() {
		return jobT;
	}
	public void setJobT(String jobT) {
		this.jobT = jobT;
	}
	public String getDeptT() {
		return deptT;
	}
	public void setDeptT(String deptT) {
		this.deptT = deptT;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	public MainVo getMainVo() {
		return mainVo;
	}
	public void setMainVo(MainVo mainVo) {
		this.mainVo = mainVo;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getEduYearTerm() {
		return eduYearTerm;
	}
	public void setEduYearTerm(int eduYearTerm) {
		this.eduYearTerm = eduYearTerm;
	}
	public int getEduMonthTerm() {
		return eduMonthTerm;
	}
	public void setEduMonthTerm(int eduMonthTerm) {
		this.eduMonthTerm = eduMonthTerm;
	}
	public int getCarYearTerm() {
		return carYearTerm;
	}
	public void setCarYearTerm(int carYearTerm) {
		this.carYearTerm = carYearTerm;
	}
	
	public int getCarMonthTerm() {
		return carMonthTerm;
	}
	public void setCarMonthTerm(int carMonthTerm) {
		this.carMonthTerm = carMonthTerm;
	}
	public int getEduWeekTerm() {
		return eduWeekTerm;
	}
	public void setEduWeekTerm(int eduWeekTerm) {
		this.eduWeekTerm = eduWeekTerm;
	}
	public int getCarWeekTerm() {
		return carWeekTerm;
	}
	public void setCarWeekTerm(int carWeekTerm) {
		this.carWeekTerm = carWeekTerm;
	}
	@Override
	public String toString() {
		return "MainVo [empNo=" + empNo + ", name=" + name + ", residentNum=" + residentNum + ", hiredate=" + hiredate
				+ ", phone=" + phone + ", email=" + email + ", dept=" + dept + ", jobTitle=" + jobTitle + ", skillCode="
				+ skillCode + ", skillGrade=" + skillGrade + ", skill=" + skill + ", stateY=" + stateY + ", stateDate="
				+ stateDate + ", adminY=" + adminY + ", adminPw=" + adminPw + ", jobT=" + jobT + ", deptT=" + deptT
				+ ", state=" + state + ", mainVo=" + mainVo + ", page=" + page + ", startNum=" + startNum + ", endNum="
				+ endNum + ", recordCount=" + recordCount + ", pageCount=" + pageCount + ", pageSize=" + pageSize
				+ ", blockSize=" + blockSize + ", startPage=" + startPage + ", endPage=" + endPage + ", endP=" + endP
				+ ", eduYearTerm=" + eduYearTerm + ", eduMonthTerm=" + eduMonthTerm + ", eduWeekTerm=" + eduWeekTerm
				+ ", carYearTerm=" + carYearTerm + ", carMonthTerm=" + carMonthTerm + ", carWeekTerm=" + carWeekTerm
				+ "]";
	}
	
	
}

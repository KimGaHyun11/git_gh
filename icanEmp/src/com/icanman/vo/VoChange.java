package com.icanman.vo;

public class VoChange {

	//state > java
	public String title(MainVo mainVo) {
		String stat = null;
		String stateDate = mainVo.getStateDate();
		
		switch (mainVo.getStateY()) {
		case 0://재직
			stat = "";
			break;
		case 1://휴직
			stat = "휴직 ( " + stateDate + " ) ";
			break;
		case 2://퇴직
			stat = "퇴직 ( " + stateDate + " ) ";
			break;
		}
		return stat;
	}

	//dept > java
	public String deptTitle(MainVo mainVo) {
		String deptT = null;
		int dept = mainVo.getDept();

		switch (dept) {
		case 1:
			deptT = "총괄";
			break;
		case 2:
			deptT = "관리";
			break;
		case 3:
			deptT = "경영";
			break;
		case 4:
			deptT = "개발";
			break;
		}
		return deptT;

	}

	//jobTitle > java
	public String jobTitle(MainVo mainVo) {
		String jobT = null;
		int jobTitle = mainVo.getJobTitle();

		switch (jobTitle) {
		case 1:
			jobT = "사장";
			break;
		case 2:
			jobT = "전무";
			break;
		case 3:
			jobT = "실장";
			break;
		case 4:
			jobT = "주임";
			break;
		case 5:
			jobT = "과장";
			break;
		case 6:
			jobT = "팀장";
			break;
		case 7:
			jobT = "대리";
			break;
		case 8:
			jobT = "사원";
			break;
		case 9:
			jobT = "수습";
			break;
		}
		return jobT;
	}

	// java > dept 
	public int deptReturn(String deptT) {

		int dept = 0;

		switch (deptT) {
		case "총괄":
			dept = 0;
			break;
		case "관리":
			dept = 1;
			break;
		case "경영":
			dept = 2;
			break;
		case "개발":
			dept = 3;
			break;
		}
		
		return dept;

	}

	// java > dept 
	public int jobReturn(String jobT) {
		int jobTitle = 0;

		switch (jobT) {
		case  "사장":
			jobTitle = 0;
			break;
		case "전무":
			jobTitle = 1;
			break;
		case "실장":
			jobTitle = 2;
			break;
		case "주임":
			jobTitle = 3;
			break;
		case "과장":
			jobTitle = 4;
			break;
		case "팀장":
			jobTitle = 5;
			break;
		case "대리":
			jobTitle = 6;
			break;
		case "사원":
			jobTitle = 7;
			break;
		case "수습":
			jobTitle = 8;
			break;
		}
		return jobTitle;
	}
}

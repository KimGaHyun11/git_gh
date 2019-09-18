package com.icanman.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icanman.dao.LoginDao;
import com.icanman.service.LoginService;
import com.icanman.vo.MainVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action{

	private int empNo;
	private String adminPw;
	private String name;
	
	private String msg;
	private String url;

	

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public String execute() throws Exception {	
		
		System.out.println("LoginAction");

		LoginService service = new LoginService();
		MainVo mainVo = new MainVo();
		mainVo = service.login(empNo);

		
		msg = "아이디나 비밀번호를 확인해주세요.";
		url = "javascript:history.back();";
		
		if(mainVo.getAdminPw().equals("0000")) {
			msg = "초기 비밀번호는 0000입니다. 로그인 후 암호를 변경해주시기 바랍니다.";
		}

		System.out.println("login: "+empNo);
		System.out.println("login: "+name);

		if(adminPw.equals(mainVo.getAdminPw())) {					
				//세션에 아이디저장
				ActionContext context = ActionContext.getContext();
				Map<String, Object> session = context.getSession();
				session.put("empNo", empNo);
				session.put("name", mainVo.getName());
				context.setSession(session);
				
				System.out.println("LoginSession : " + context.getContext().getSession().get("empNo"));
				System.out.println("LoginSession : " + context.getContext().getSession().get("name"));
			
				//Object name = ActionContext.getContext().getSession().get("name");
				//세션에서 값꺼낼때 사용
		
			msg = mainVo.getName()+ "님, 환영합니다.";					
			url = "eList.action";

		}
		return "login";
	}
	
	

}

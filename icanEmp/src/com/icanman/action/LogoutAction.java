package com.icanman.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction implements Action{


	@Override
	public String execute() throws Exception {
		
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = (Map<String, Object>)context.getSession();
		
		System.out.println("LogoutSession1 : " + context.getContext().getSession().get("empNo"));
		System.out.println("LogoutSession1 : " + context.getContext().getSession().get("name"));
		if(session.get("empNo") != null) {
			session.remove("empNo");
			session.remove("name");	
		}
		context.setSession(session);
		System.out.println("LogoutSession2 : " + context.getContext().getSession().get("empNo"));
		System.out.println("LogoutSession2 : " + context.getContext().getSession().get("name"));
		
		return "logout";
	}

}

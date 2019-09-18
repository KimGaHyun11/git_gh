package com.icanman.action;

import java.util.Map;

import com.icanman.service.ModifiedService;
import com.icanman.vo.AllVo;
import com.icanman.vo.MainVo;
import com.icanman.vo.SchoolVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ModifiedAction implements Action, Preparable, ModelDriven<AllVo> {
	private String msg;
	private String url;
	private MainVo mainVo;
	private AllVo allVo;

	@Override
	public AllVo getModel() {
		return allVo;
	}

	@Override
	public void prepare() throws Exception { //클래스 호출 시 자동실행되는 execute메소드 전에 다른로직을 실행하고싶을때 
		allVo = new AllVo();

	}

	@Override
	public String execute() throws Exception {
		System.out.println("ModifiedAction");
		System.out.println("all : " + allVo.getMainVo().toString());

		//세션empNo값 가져오기(adminRecord기록위함)
		int adminEmpNo = (int) ActionContext.getContext().getSession().get("empNo");		
		System.out.println("adminEmpNo : " + adminEmpNo);
		
		ModifiedService service = new ModifiedService();
		Map<String, String> modifiedResult = service.modified(allVo, adminEmpNo);
		String name = modifiedResult.get("name");

		
		msg = "[입력실패]";
		url = "eModify.action?empNo=" + allVo.getMainVo().getEmpNo();

		
		if (modifiedResult.values() != null) {
			msg = name + "님의 정보가 성공적으로 수정되었습니다.";
			url = "eView.action?empNo=" + allVo.getMainVo().getEmpNo();
		}

		return "modified";
	}
	//getter/setter =================================================

	
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

	public MainVo getMainVo() {
		return mainVo;
	}

	public void setMainVo(MainVo mainVo) {
		this.mainVo = mainVo;
	}

	public AllVo getAllVo() {
		return allVo;
	}

	public void setAllVo(AllVo allVo) {
		this.allVo = allVo;
	}

}

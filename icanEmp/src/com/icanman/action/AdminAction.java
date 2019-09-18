package com.icanman.action;

import java.util.List;

import com.icanman.service.AdminService;
import com.icanman.vo.AdminVo;
import com.icanman.vo.AllVo;
import com.icanman.vo.PagingVo;
import com.opensymphony.xwork2.Action;

public class AdminAction  implements Action{

	
	private AllVo allVo;
	private List<AdminVo> adminList;
	private PagingVo pagingVo;
	private int page;
	private int listSize;
	
	@Override
	public String execute() throws Exception {
		AdminService service = new AdminService();		
		allVo = service.adminList(page);
		adminList = allVo.getAdminList();
		listSize = adminList.size();
		pagingVo = allVo.getPagingVo();
		
		System.out.println(pagingVo);
		return "admin";
	}


	public AllVo getAllVo() {
		return allVo;
	}


	public void setAllVo(AllVo allVo) {
		this.allVo = allVo;
	}


	public List<AdminVo> getAdminList() {
		return adminList;
	}


	public void setAdminList(List<AdminVo> adminList) {
		this.adminList = adminList;
	}


	public PagingVo getPagingVo() {
		return pagingVo;
	}


	public void setPagingVo(PagingVo pagingVo) {
		this.pagingVo = pagingVo;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getListSize() {
		return listSize;
	}


	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	

	

}

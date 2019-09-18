package com.icanman.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icanman.service.ListService;
import com.icanman.vo.AllVo;
import com.icanman.vo.MainVo;
import com.icanman.vo.PagingVo;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {

	private AllVo allVo;
	private PagingVo pagingVo;
	private List<MainVo> list;
	private int listSize;
	private MainVo mainVo;
	private String select; //검색종류
	private String deptSelect;
	private String jobSelect;
	private String search; //검색내용
	private String msg; //총 건 알림메시지

	private String retiree; //재직자 조회 구분   value값이 reti면 재직자만 , all이면 전체조회
	int page;

	int empNo;

	@Override
	public String execute() throws Exception {
		System.out.println("ListAction");
		System.out.println("select : " + select + ", search : " + search);
		System.out.println("retiree : " + retiree);

		ListService service = new ListService();

		if(retiree == null || retiree.equals("")) { retiree = "reti"; }
		if(select == null) {select = "";}
		if(search == null) {search = "";}
		if(deptSelect == null) {deptSelect = "";}
		if(jobSelect == null) {jobSelect = "";}

		//서비스로 넘길 값이 많으므로 string은 map으로 묶어 보내기
		Map<String, String> map = new HashMap<String, String>();
		map.put("select", select);
		map.put("search", search);
		map.put("retiree", retiree);
		map.put("deptSelect", deptSelect);
		map.put("jobSelect", jobSelect);
		
		allVo = service.list(map, page);
		
		pagingVo = allVo.getPagingVo();
		
		System.out.println("pagingVo : " + pagingVo);
		
		list = allVo.getMainList();
	
		listSize = list.size();
		//건수 메시지
		if (listSize > 0) {			
				msg = "총 " + pagingVo.getRecordCount() + "건이 검색되었습니다. ";			
		} else {
			msg = "검색된 데이터가 없습니다.";
		}

		return "list";
	}

	public AllVo getAllVo() {
		return allVo;
	}

	public void setAllVo(AllVo allVo) {
		this.allVo = allVo;
	}

	public PagingVo getPagingVo() {
		return pagingVo;
	}

	public void setPagingVo(PagingVo pagingVo) {
		this.pagingVo = pagingVo;
	}

	public List<MainVo> getList() {
		return list;
	}

	public void setList(List<MainVo> list) {
		this.list = list;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public MainVo getMainVo() {
		return mainVo;
	}

	public void setMainVo(MainVo mainVo) {
		this.mainVo = mainVo;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	

	public String getDeptSelect() {
		return deptSelect;
	}

	public void setDeptSelect(String deptSelect) {
		this.deptSelect = deptSelect;
	}

	public String getJobSelect() {
		return jobSelect;
	}

	public void setJobSelect(String jobSelect) {
		this.jobSelect = jobSelect;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRetiree() {
		return retiree;
	}

	public void setRetiree(String retiree) {
		this.retiree = retiree;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	
	
}

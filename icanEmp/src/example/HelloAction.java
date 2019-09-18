package example;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action{
	
	private String name;
	private String msg;  
	

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String execute() throws Exception{
		msg = "안녕" + name;
		return SUCCESS;
	}

	
	
	
	
	

}

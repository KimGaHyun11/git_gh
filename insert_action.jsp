<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//title변수에 request.getParameter로 괄호 안의 이름을 갖는 내용을 담도록
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");

	String sql = "INSERT INTO m1board(no, title, name, password, content)"
			+ "VALUES(m1board_seq.nextval, ?, ?, ?, ?)";

	boolean result = false;

	Connection cn = null;
	PreparedStatement ps = null;

	try {
		Class.forName("oracle.jdbc.OracleDriver"); //oracleDriver가 있는지 확인
		cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "oraclejava", "oraclejava"); //connection 연결

		ps = cn.prepareStatement(sql);
		
		//sql문에 물음표 순서대로 변수데이터를 집어넣기
		ps.setString(1, title);
		ps.setString(2, name);
		ps.setString(3, password);
		ps.setString(4, content);
		
		ps.executeUpdate();
		
		result = true;

	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		if(ps != null) try{ps.close(); }catch(Exception e){}
		if(cn != null) try{cn.close(); }catch(Exception e){}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
<% if(result){ %>

  alert("글이 등록되었습니다.");
  location.href = "list.jsp";   //다음 이동할 페이지
<%}else{%>
  alert("글이 등록이 실패하였습니다.");
  location.href = "javascript:history.back();"; //브라우저의 back버튼 누른효과(뒤로가기) 
<%}%>

</script>



</body>
</html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="../css/board.css" type="text/css" />
</head>
<body>
<table width="600">
  <caption>게시판 리스트</caption>
  <tr>
    <th>글번호</th>
    <th>제  목</th>
    <th>이  름</th>
    <th>작성일</th>
    <th>조회수</th>
  </tr>
  
<%
  Connection cn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  
  String sql = "SELECT no, title, name, to_char(writeday,'YYYY-MM-DD')AS writeday, readcount FROM m1board ORDER BY no DESC";
  
  try{
	  Class.forName("oracle.jdbc.OracleDriver"); //oracleDriver가 있는지 확인
		cn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "oraclejava", "oraclejava"); //connection 연결
        ps = cn.prepareStatement(sql);
		rs = ps.executeQuery();  //조회 결과 얻어오기
		
		while(rs.next()){
%>
		<tr>
		  <td><%= rs.getLong("no") %></td>
		  <td><%= rs.getString("title") %></td>
		  <td><%= rs.getString("name") %></td>
		  <td><%= rs.getString("writeday") %></td>
	      <td align="right"><%= rs.getInt("readcount") %></td>
		</tr>

<%
		}
  }catch(Exception e){
	  e.printStackTrace();
	  
  }finally{
	  if(rs != null) try{rs.close();}catch(Exception e){}
	  if(ps != null) try{ps.close();}catch(Exception e){}
	  if(cn != null) try{cn.close();}catch(Exception e){}
	  
  }
%>


</table>

<a href ="insert.jsp">[글쓰기]</a>
</body>
</html>
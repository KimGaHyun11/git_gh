<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 

     Connection conn = null;
     boolean result = false;
     
     try{
    	 Class.forName("org.postgresql.Driver");
    	 
    	 conn = DriverManager.getConnection(
    			 "jdbc:postgresql://ec2-107-22-211-248.compute-1.amazonaws.com:5432/dd8u93qv6p4luh",
    			 "jnfpmwwvodikng",
    			 "35469c50093cb3101cf5ebd7400271c08ad1b337f3b8924479ad3af4ac371c93");  

    	      
    	 result = true;
    	 
     }catch(Exception e){
    	 e.printStackTrace();
    	 
     }finally{
    	 if(conn != null) try{  conn.close(); }catch(Exception e){}
     }
       
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  if(result){ %>
  DB연결 성공
	   
<%}else{ %> 
  DB연결 실패
	   
<%} %>  
  



</body>
</html>
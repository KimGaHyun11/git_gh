<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이캔매니지먼트</title>

<link rel="stylesheet" href="../css/login.css" type="text/css" />

</head>
<body>

	<form action=eLogin.action?  id="logForm" method=POST  style="height: 397px; ">
	<img src="../img/icanLogo.PNG "><p/>
	<div>
		<div>
		<input type="text"     id=empNo   name=empNo    required=required autofocus=autofocus value="201900043"><br/>
		<input type="password" id=adminPw name=adminPw  required=required value="1212"> <br/>
		</div>
		
		</div><br/><input type="submit" id="loginBtn" name="loginBtn" value="LOGIN" >
	</form>


</body>
</html>
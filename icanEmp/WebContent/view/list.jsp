<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이캔매니지먼트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/list.js?ver=1"></script>
<link rel="stylesheet" href="../css/list.css" />

</head>
<body>
<img src="../img/icanLogo.PNG " onclick="location.href='eList.action'" style="cursor:pointer"><p/>
    ${name }님, 환영합니다.
	<input type="button" value="내정보" onclick="location.href='eView.action?empNo=${sessionScope.empNo }'"/>
	<input type="button" id="logout" value="LOGOUT"
		onclick="logoutConfirm()">
	<br />

	<form id="listForm" method="GET" action="eList.action?retiree='${retiree}'">
		<input type="button" id="ins" value="사원 신규등록"
			onclick="location.href='eInsert.action'"><br />

		<div>
			<input type="checkbox" id="checkR" name="checkR"
				<s:if test="%{retiree.equals('reti')}">checked="checked"</s:if>>재직자만 조회하기 <br/>
				<input type="hidden" id="retiree" name="retiree" /> 
			
			<select name="select" id="select">			
				<option value="">--검색--</option>
				<option value="empNo" <s:if test="%{select.equals('empNo')}">selected</s:if>>사원번호</option>
				<option value="name" <s:if test="%{select.equals('name')}">selected</s:if>>이름</option>
				<option value="jobTitle" <s:if test="%{select.equals('jobTitle')}">selected</s:if>>직책</option>
				<option value="dept" <s:if test="%{select.equals('dept')}">selected</s:if>>부서</option>
				<option value="phone" <s:if test="%{select.equals('phone')}">selected</s:if>>연락처</option>
			</select> 
		
			
			<span id="deptS">
			<select name="deptSelect" id="deptSelect">
				 <option value="">부서 선택</option>
  			     <option value="1" <s:if test="%{deptSelect ==1}">selected</s:if>>총괄</option>
  			     <option value="2" <s:if test="%{deptSelect ==2}">selected</s:if>> 관리</option>
   		    	 <option value="3" <s:if test="%{deptSelect ==3}">selected</s:if>>경영</option>
 			     <option value="4" <s:if test="%{deptSelect ==4}">selected</s:if>>개발</option>
			</select> 
			</span>
			
			<span id="jobS">
			<select name="jobSelect" id="jobSelect">
				 <option value="" >직책 선택</option>
     	         <option value="1" <s:if test="%{jobSelect ==1}">selected</s:if>>사장</option>
       		     <option value="2" <s:if test="%{jobSelect ==2}">selected</s:if>>전무</option>
  			     <option value="3" <s:if test="%{jobSelect ==3}">selected</s:if>>실장</option>
       	         <option value="4" <s:if test="%{jobSelect ==4}">selected</s:if>>주임</option>
                 <option value="5" <s:if test="%{jobSelect ==5}">selected</s:if>>과장</option>
                 <option value="6" <s:if test="%{jobSelect ==6}">selected</s:if>>팀장</option>
                 <option value="7" <s:if test="%{jobSelect ==7}">selected</s:if>>대리</option>
                 <option value="8" <s:if test="%{jobSelect ==8}">selected</s:if>>사원</option>
                 <option value="9" <s:if test="%{jobSelect ==9}">selected</s:if>>수습</option>
            </select>
			</span>
			
			<input type="text" id="search" name="search" value="${search }">
			<input type="submit" value="검색">
		</div>


		<label id="msg">${msg }</label>


		<table style="width: 750px;">
			<tr align="center">
				<th>사원번호</th>
				<th>이름</th>
				<th>직책</th>
				<th>부서</th>
				<th>연락처</th>
				<th>비고</th>
			</tr>

			<s:iterator value="%{list}"  status="row">
				<tr>
					<td><s:property value="empNo"/></td>
					<td><a
						href="eView.action?empNo=${empNo }&retiree=${retiree}&page=${pagingVo.page}">
							<s:property value="name" />
					</a></td>
					<td><s:property value="jobT" /></td>
					<td><s:property value="deptT" /></td>
					<td><s:property value="phone" /></td>
					<td><s:property value="state" /></td>
				</tr>
			</s:iterator>
		</table><br/>



		<div id="paging">
			
				<s:if test="%{listSize > 0}">
					<s:if test="%{pagingVo.page != 1 }">
							<a href="eList.action?page=1&retiree=${retiree}">◁◁</a>
							<a href="eList.action?page=${pagingVo.page-1 }&retiree=${retiree}">◀</a>
						</s:if> <s:iterator var="pNum" begin="%{pagingVo.startPage }"
							end="%{pagingVo.endPage }">
							<s:if test="%{pNum == pagingVo.page}"> ${pNum}</s:if>
							<s:if test="%{pNum != pagingVo.page}">
								<a href="eList.action?page=${pNum}&retiree=${retiree}">
									${pNum} </a>
							</s:if>
						</s:iterator> <s:if test="%{pagingVo.page != pagingVo.endPage }">
							<a href="eList.action?page=${pagingVo.page+1 }&retiree=${retiree}">▶</a>
							<a href="eList.action?page=${pagingVo.endPage }&retiree=${retiree}">▷▷</a>
						</s:if>
				</s:if>
				
		</div>
		
		<input type="button" value="관리자 활동이력" onclick="location.href='eAdmin.action'"/>

	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/list.css" />
</head>
<body>
<img src="../img/icanLogo.PNG " onclick="location.href='eList.action'" style="cursor:pointer" >
<h2>관리자 활동리스트</h2><p/>

		<table style="width: 750px;">
			<tr align="center">
				<th>관리자</th>
				<th>사원</th>
				<th>활동시간</th>
				<th>활동내용</th>
			</tr>

			<s:iterator value="%{adminList}"  status="row">
				<tr>
					<td><s:property value="empNo"/>( <s:property value="empName"/> )</td>					
					<td><s:property value="objectEmpNo"/>( <s:property value="objectName"/> )</td>
					<td><s:property value="recordDay" /></td>
					<td><s:property value="recordContent" /></td>
				</tr>
			</s:iterator>
		</table><br/>
		
		<div id="paging">
			
				<s:if test="%{listSize > 0}">
					<s:if test="%{pagingVo.page != 1 }">
							<a href="eAdmin.action?page=1">◁◁</a>
							<a href="eAdmin.action?page=${pagingVo.page-1 }">◀</a>
						</s:if> <s:iterator var="pNum" begin="%{pagingVo.startPage }"
							end="%{pagingVo.endPage }">
							<s:if test="%{pNum == pagingVo.page}"> ${pNum}</s:if>
							<s:if test="%{pNum != pagingVo.page}">
								<a href="eAdmin.action?page=${pNum}">
									${pNum} </a>
							</s:if>
						</s:iterator> <s:if test="%{pagingVo.page != pagingVo.endPage }">
							<a href="eAdmin.action?page=${pagingVo.page+1 }">▶</a>
							<a href="eAdmin.action?page=${pagingVo.endPage }">▷▷</a>
						</s:if>
				</s:if>
		</div>
		
		
		
		  <input type="button" id="listBtn" value="리스트" onclick="location.href='eList.action'">
</body>
</html>
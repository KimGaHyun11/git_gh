<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="paging">

<s:bean name="org.apache.struts2.util.Counter" id="pVo">
   <s:param name=startPage" value="${pVo.startPage }"/>
   <s:param name=endPage" value="${pVo.endPage }"/>
</s:bean>




<table>
<s:if test="%{pVo.prev}">
 <a href="eList.action?page=${pVo.startPage -1 }">prev</a>
</s:if>
<s:iterator value="pVo" status="stat">
  <tr>
    <td><s:property value="%{pVo.page}"/></td>
  </tr>
  </s:iterator>
  
<s:if test="%{pVo.next}">
 <a href="eList.action?page=${pVo.endPage+1 }">next</a>
</s:if>
</table>

</div>


</body>
</html>
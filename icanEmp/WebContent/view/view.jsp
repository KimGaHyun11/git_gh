<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이캔매니지먼트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/view.js"></script>
<link rel ="stylesheet" href ="../css/view.css"/>
</head>
<body>
<form>
<img src="../img/icanLogo.PNG"  onclick="location.href='eList.action'"  style="cursor:pointer" >
<h2>사원조회</h2><p/>

<table id='basic'>
  <tr>
   <th>사원번호</th>
   <td  colspan="3">${mainVo.empNo }</td>
   </tr>
   <tr>
   <th>사원명</th>
   <td>${mainVo.name }</td>
   <th>입사일자</th>
   <td>${mainVo.hiredate }</td>
  </tr>
   <tr>
   <th>주민번호</th>
   <td>${mainVo.residentNum }</td>
   <th>부서</th>
   <td>${mainVo.deptT}</td>
  </tr>
   <tr>
   <th>연락처</th>
   <td>${mainVo.phone }</td>
   <th>직책</th>
   <td>${mainVo.jobT }</td>
  </tr>
  <tr>
   <th>이메일</th>
   <td>${mainVo.email }</td>
   <th>SKILLCODE</th>
   <td>${mainVo.skillCode }</td>
  </tr>
  <tr>
   <th>보유기술</th>
   <td>${mainVo.skill }</td>
   <th>기술등급</th>
   <td>${mainVo.skillGrade }</td>
  </tr>
  <tr>
   <th>상태</th>
   <td  colspan="3">${mainVo.state }</td>
  
  </tr>
  </table>
  <p/>
 
    
  <table> 
   <tr>
   <td class="targetCell">학력</td>
   <td>학교명</td>
   <td>입학일자</td>
   <td>졸업일자</td>
   <td>전공명</td>
  </tr>
  <s:iterator value="schoolList">
  <tr>
   <td class="targetCell">학력</td>
  <td><s:property value="schoolName"/></td>
  <td><s:property value="startDay"/></td>
  <td><s:property value="endDay"/></td> 
  <td><s:property value="major"/></td>
  </tr>
  </s:iterator>
  </table>
   <p/>

  
  <table>  
   <tr>
   <td  class="targetCell">자격증</td>
   <td>자격증명</td>
   <td>발행기관</td>
   <td>취득일자</td>
  </tr>
  <s:iterator value="certificationList" > 
  <tr>
  <td class="targetCell">자격증</td>
  <td><s:property value="certificationName"/></td>
  <td><s:property value="agency"/></td> 
  <td><s:property value="acpDate"/></td>
  </tr>
  </s:iterator>
  </table>
   <p/>

   <table> 
   <tr>
  <td class="targetCell">경력<br/>
           [ ${mainVo.carYearTerm }년 ${mainVo.carMonthTerm }개월  ${mainVo.carWeekTerm }주] </td>
   <td>회사명</td>
   <td>입사일</td>
   <td>퇴사일</td>
   <td>직위</td>
   <td>담당업무</td>
   <td>퇴직사유</td>
  </tr>
  
  <s:iterator value="careerList">
  <tr>
  <td class="targetCell">경력<br/>
           [ ${mainVo.carYearTerm }년 ${mainVo.carMonthTerm }개월  ${mainVo.carWeekTerm }주] </td>
  <td><s:property value="beforeEmp"/></td>
  <td><s:property value="startDay"/></td>
  <td><s:property value="endDay"/></td> 
  <td><s:property value="title"/></td>
  <td><s:property value="beforeWork"/></td>
  <td><s:property value="retirement"/></td>
  </tr>
  </s:iterator>
  </table>
   <p/>
  
  
   <table> 
   <tr>
    <td class="targetCell">교육<br/>
           [ ${mainVo.eduYearTerm }년 ${mainVo.eduMonthTerm }개월  ${mainVo.eduWeekTerm }주] </td>
   <td>교육기관</td>
   <td>교육시작일</td>
   <td>교육종료일</td>
   <td>교육내용</td>
  </tr>

  <s:iterator value="educationList">
  <tr>
    <td class="targetCell">교육<br/>
           [ ${mainVo.eduYearTerm }년 ${mainVo.eduMonthTerm }개월  ${mainVo.eduWeekTerm }주] </td>
  <td><s:property value="institute"/></td>
  <td><s:property value="startDay"/></td>
  <td><s:property value="endDay"/></td> 
  <td><s:property value="content"/></td>
  </tr>
  </s:iterator>
  </table>


  <input type="button" id="listBtn" value="리스트" onclick="location.href='eList.action?retiree='${retiree}">
  <input type="button" id="modifyBtn" value="수정" onclick="location.href='eModify.action?empNo=${mainVo.empNo }'">
  <input type="button" id="ins" value="신규등록" onclick="location.href='eInsert.action'" ><br/>
  



</form>
</body>
</html>
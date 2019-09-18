<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이캔매니지먼트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/insert.js?ver=11"></script>
<link rel ="stylesheet" href ="../css/insert.css"/>
</head>
<body>
<img src="../img/icanLogo.PNG " onclick="listBackConfirm()" style="cursor:pointer"><br/>
<h2 >사원등록</h2 >
<h4> *이 붙은 항목은 필수입력항목입니다. </h4>
<hr/>
<form id="insForm" method="post" action="eInput.action">

<label>* 사원명 </label>
<input type="text" id="name" name="mainVo.name"  autofocus=autofocus placeholder="2글자 이상 한글이나 영어" autocomplete="off"/><br/>
<label>* 주민번호 </label>
<input type="text" id="jumin1" name="mainVo.jumin1" autocomplete="off" /> -
<input type="text" id="jumin2" name="mainVo.jumin2" autocomplete="off"/><br/>
<input type="hidden" id="residentNum" name="mainVo.residentNum">
<label>*입사일자</label>
<input type="date" id="hiredate" name="mainVo.hiredate"  required=required/><br/>
<label>* 연락처 </label>
<input type="text" id="phone1" name="mainVo.phone1"  autocomplete="off"/> -
<input type="text" id="phone2" name="mainVo.phone2" autocomplete="off"/> -
<input type="text" id="phone3" name="mainVo.phone3"  autocomplete="off"/>

<input type="hidden" id="phone" name="mainVo.phone" /><br/>
<label>* 이메일</label>
<input type="text" id="email1" name="mainVo.email1"  autocomplete="off"> @
<select name="mainVo.email2" id="email2"  >
   <option value="">이메일선택</option>
   <option value="naver.com">naver.com</option>
   <option value="nate.com">nate.com</option>
   <option value="daum.net">daum.net</option>
   <option value="gmail.com">gmail.com</option>
</select><br/>
<input type="hidden" id="email" name="mainVo.email">


<label>* 부서</label>
<select name="mainVo.dept" id="dept" > 
   <option value="">부서 선택</option>
   <option value="1">총괄</option>
   <option value="2">관리</option>
   <option value="3">경영</option>
   <option value="4">개발</option>
</select>

<label>* 직책</label>
<select name="mainVo.jobTitle" id="jobTitle" >
   <option value="">직책 선택</option>
   <option value="1">사장</option>
   <option value="2">전무</option>
   <option value="3">실장</option>
   <option value="4">주임</option>
   <option value="5">과장</option>
   <option value="6">팀장</option>
   <option value="7">대리</option>
   <option value="8">사원</option>
   <option value="9">수습</option>
</select><br/>

<label>Skill Code</label>
<input type="text" id="skillCode" name="mainVo.skillCode" autocomplete="off">
<label>기술등급</label>
<input type="text" id="skillGrade" name="mainVo.skillGrade" autocomplete="off"><br/>
<label>보유기술</label>
<input type="text" id="skill" name="mainVo.skill" autocomplete="off"><br/>


<label>학력</label>
<input type="button" value="+" onclick="schoolPlus()">

<table id="schoolTable">
<thead>
<tr>
<th>입학일자</th>
<th>졸업일자</th>
<th>학교</th>
<th>전공</th>
</tr>
</thead>
<tbody id="schoolTableB">
<tr>
<td><input type="date" id="scStartDay" name="schoolList[0].startDay" ></td>
<td><input type="date" id="scEndDay" name="schoolList[0].endDay" > </td>
<td><input type="text"  id="schoolName" name="schoolList[0].schoolName"></td>
<td><input type="text"  id="major" name="schoolList[0].major" ></td>


</tr>
</tbody>
</table>

<label>보유자격증</label>
<input type="button" value="+" onclick="certiPlus()" >
<table id="certiTable">
<thead>
<tr>
<th style="width: 140px; ">최득일자</th>
<th style="width: 305px; ">자격증명</th>
<th>발행기관</th>
</tr>
</thead>

<tbody id="certiTableB">
<tr>
<td><input type="date" id="acpDate" name="certificationList[0].acpDate" ></td>
<td><input type="text"  id="certificationName" name="certificationList[0].certificationName"/></td>
<td><input type="text"  id="agency" name="certificationList[0].agency"/></td>
</tr>
</tbody>
</table>
 

<div>
<input type="button" id=careerPlus" value="경력사항 추가" onclick="careerDisplay()" >
<input type="button" id=eduPlus" value="교육사항 추가" onclick="eduDisplay()">
</div>

<div id="carView" style="display: none">
<h3 class="carPlus">경력사항</h3>
<input type="button" value="+" onclick="careerPlus()">
<table id="careerTable">
<thead>
<tr>
<th >근무회사명</th>
<th>근무시작일</th>
<th >근무종료일</th>
<th>직위</th>
<th>담당업무</th>
<th>퇴직사유</th>
</tr>
</thead>
<tbody id="careerTableB">
<tr>
<td><input type="text"  id="carEmp" name="careerList[0].beforeEmp"></td>
<td><input type="date" id="carStartDay" name="careerList[0].startDay" ></td>
<td><input type="date" id="carEndDay" name="careerList[0].endDay"> </td>
<td><input type="text"  id="carTitle" name="careerList[0].title"></td>
<td><input type="text"  id="carWork" name="careerList[0].beforeWork"></td>
<td><input type="text"  id="carRetirement" name="careerList[0].retirement"></td>
</tr>
</tbody>
</table>
</div>

<div id="eduView" style="display: none">
<h3>교육사항</h3>
<input type="button" value="+" onclick="eduPlus()">
<table id="eduTable">
<thead>
<tr>
<th>교육기관명</th>
<th>교육시작일</th>
<th>교육종료일</th>
<th>교육내용</th>
</tr>
</thead>
<tbody id="eduTableB">
<tr>
<td><input type="text"  id="eduInsititute" name="educationList[0].institute"></td>
<td><input type="date" id="eduStartDay" name="educationList[0].startDay" ></td>
<td><input type="date" id="eduEndDay" name="educationList[0].endDay"> </td>
<td><input type="text" id="eduContent" name="educationList[0].content"></td>
</tr>
</tbody>
</table>
</div>

<div>
<input type="button" id="cancel" value="취소" onclick="listBackConfirm()">
<input type="button" id="insBtn" value="확인" onclick="inSuccess()">
</div>
</form>

</body>
</html>
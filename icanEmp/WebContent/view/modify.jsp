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
<script type="text/javascript" src="../js/modify.js?ver=12"></script>
<link rel="stylesheet" href="../css/insert.css" />
</head>
<body>
<img src="../img/icanLogo.PNG " onclick="listBackConfirm()" style="cursor:pointer" >
<h2 >사원수정</h2 >
<h4> *이 붙은 항목은 필수입력항목입니다. </h4>
<hr/>
	<form id="insForm" name="insForm" method="post"
		action="eModified.action">
		<label> 사원번호 </label> <input type="text" id="empNo"
			name="mainVo.empNo" value="${mainVo.empNo }" readonly="readonly"><br />
		<label>* 사원명 </label> <input type="text" id="name" name="mainVo.name"
			value="${mainVo.name }" /><br /> <label>* 주민번호 </label> <input
			type="text" id="jumin1" name="mainVo.jumin1" value="${jumin1 }" /> -
		<input type="text" id="jumin2" name="mainVo.jumin2" value="${jumin2 }" /><br />
		<input type="hidden" id="residentNum" name="mainVo.residentNum">
		<label>*입사일자</label> <input type="date" id="hiredate"
			name="mainVo.hiredate" value="${mainVo.hiredate}" /><br /> <label>*
			연락처 </label> <input type="text" id="phone1" name="mainVo.phone1"
			value="${phone1}" /> - 
			<input type="text" id="phone2"
			name="mainVo.phone2" value="${phone2 }" /> - <input type="text"
			id="phone3" name="mainVo.phone3" value="${phone3 }" /> <input
			type="hidden" id="phone" name="mainVo.phone" required=required /><br />
		<label>* 이메일</label> <input type="text" id="email1"
			name="mainVo.email1" value="${email1 }"> @ <select
			name="mainVo.email2" id="email2">
			<option>이메일선택</option>
			<option value="naver.com"
				<s:if test="%{email2=='naver.com'}">selected</s:if>>
				naver.com</option>
			<option value="nate.com"
				<s:if test="%{email2=='nate.com'}">selected</s:if>>nate.com</option>
			<option value="daum.net"
				<s:if test="%{email2=='daum.net'}">selected</s:if>>daum.net</option>
			<option value="gmail.com"
				<s:if test="%{email2=='gmail.com'}">selected</s:if>>gmail.com</option>
		</select><br /> <input type="hidden" id="email" name="mainVo.email"
			value="${email2 }"> <label>* 부서</label> <select
			name="mainVo.dept" id="dept" onselect="1">
			<option>부서 선택</option>
			<option value="1" <s:if test="%{mainVo.dept==1}">selected</s:if>>총괄</option>
			<option value="2" <s:if test="%{mainVo.dept==2}">selected</s:if>>관리</option>
			<option value="3" <s:if test="%{mainVo.dept==3}">selected</s:if>>경영</option>
			<option value="4" <s:if test="%{mainVo.dept==4}">selected</s:if>>개발</option>
		</select> <label>* 직책</label> <select name="mainVo.jobTitle" id="jobTitle">
			<option>직책 선택</option>
			<option value="1" <s:if test="%{mainVo.jobTitle ==1}">selected</s:if>>사장</option>
			<option value="2" <s:if test="%{mainVo.jobTitle ==2}">selected</s:if>>전무</option>
			<option value="3" <s:if test="%{mainVo.jobTitle ==3}">selected</s:if>>실장</option>
			<option value="4" <s:if test="%{mainVo.jobTitle ==4}">selected</s:if>>주임</option>
			<option value="5" <s:if test="%{mainVo.jobTitle ==5}">selected</s:if>>과장</option>
			<option value="6" <s:if test="%{mainVo.jobTitle ==6}">selected</s:if>>팀장</option>
			<option value="7" <s:if test="%{mainVo.jobTitle ==7}">selected</s:if>>대리</option>
			<option value="8" <s:if test="%{mainVo.jobTitle ==8}">selected</s:if>>사원</option>
			<option value="9" <s:if test="%{mainVo.jobTitle ==9}">selected</s:if>>수습</option>
		</select><br /> 
		<label>Skill Code</label> <input type="text" id="skillCode"
			name="mainVo.skillCode" value="${mainVo.skillCode }"> 
			<label>기술등급</label>
		<input type="text" id="skillGrade" name="mainVo.skillGrade"
			value="${mainVo.skillGrade }"><br /> 
			<label>보유기술</label> <input
			type="text" id="skill" name="mainVo.skill" value="${mainVo.skill }"><br />

		<select name="mainVo.stateY" id="stateY" >
			<option>상태</option>
			<option value="0" <s:if test="%{mainVo.stateY ==0}">selected</s:if>>재직</option>
			<option value="1" <s:if test="%{mainVo.stateY ==1}">selected</s:if>>휴직</option>
			<option value="2" <s:if test="%{mainVo.stateY ==2}">selected</s:if>>퇴직</option>
		</select>
		<span id="state">
			<input type="date" name="mainVo.stateDate" id="stateDate" value="${mainVo.stateDate }">
		</span><br/>
		
		<label>* 학력</label> <input type="button" value="+"
			onclick="schoolPlus()">

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
				<s:iterator value="schoolList" status="row">
					<tr>
						<td><input type="date" id="scStartDay"
							name="schoolList[<s:property value="#row.index"/>].startDay"
							value="<s:property value='startDay'/>"></td>
						<td><input type="date" id="scEndDay"
							name="schoolList[<s:property value="#row.index"/>].endDay"
							value="<s:property value='endDay'/>"></td>
						<td><input type="text" id="schoolName"
							name="schoolList[<s:property value="#row.index"/>].schoolName"
							value="<s:property value='schoolName'/>"></td>
						<td><input type="text" id="major"
							name="schoolList[<s:property value="#row.index"/>].major"
							value="<s:property value='major'/>"></td>
						<td><input type='button' id='sRemove' name='sRemove'
							value='삭제' onclick='schoolRemove(this)' /></td>
					</tr>
					<input type="hidden"
						name="schoolList[<s:property value="#row.index"/>].num"
						value="<s:property value='num'/>">
				</s:iterator>
			</tbody>
		</table>



		<label>보유자격증</label> <input type="button" value="+"
			onclick="certiPlus()">
		<table id="certiTable">
			<thead>
				<tr>
					<th style="width: 140px;">최득일자</th>
					<th style="width: 305px;">자격증명</th>
					<th>발행기관</th>
				</tr>
			</thead>

			<tbody id="certiTableB">
				<s:iterator value="certificationList" status="row">
					<tr>
						<td><input type="date" id="acpDate"
							name="certificationList[<s:property value="#row.index"/>].acpDate"
							value="<s:property value='acpDate'/>"></td>
						<td><input type="text" id="certificationName"
							name="certificationList[<s:property value="#row.index"/>].certificationName"
							value="<s:property value='certificationName'/>" /></td>
						<td><input type="text" id="agency"
							name="certificationList[<s:property value="#row.index"/>].agency"
							value="<s:property value='agency'/>" /></td>
						<td><input type='button' id='cRemove' value='삭제'
							onclick='certiRemove(this)' /></td>
					</tr>
					<input type="hidden"
						name="certificationList[<s:property value="#row.index"/>].num"
						value="<s:property value='num'/>">
				</s:iterator>
			</tbody>
		</table>


		<div id="carView">
			<h3 class="carPlus">경력사항</h3>
			<input type="button" value="+" onclick="careerPlus()">
			<table id="careerTable">
				<thead>
					<tr>
						<th>근무회사명</th>
						<th>근무시작일</th>
						<th>근무종료일</th>
						<th>직위</th>
						<th>담당업무</th>
						<th>퇴직사유</th>
					</tr>
				</thead>
				<tbody id="careerTableB">
					<s:iterator value="careerList" status="row">
						<tr>
							<td><input type="text" id="carEmp"
								name="careerList[<s:property value="#row.index"/>].beforeEmp"
								value="<s:property value='beforeEmp'/>"></td>
							<td><input type="date" id="carStartDay"
								name="careerList[<s:property value="#row.index"/>].startDay"
								value="<s:property value='startDay'/>"></td>
							<td><input type="date" id="carEndDay"
								name="careerList[<s:property value="#row.index"/>].endDay"
								value="<s:property value='endDay'/>"></td>
							<td><input type="text" id="carTitle"
								name="careerList[<s:property value="#row.index"/>].title"
								value="<s:property value='title'/>"></td>
							<td><input type="text" id="carWork"
								name="careerList[<s:property value="#row.index"/>].beforeWork"
								value="<s:property value='beforeWork'/>"></td>
							<td><input type="text" id="carRetirement"
								name="careerList[<s:property value="#row.index"/>].retirement"
								value="<s:property value='retirement'/>"></td>
							<td><input type='button' id='rRemove' value='삭제'
								onclick='careerRemove(this)' /></td>
						</tr>
						<input type="hidden"
							name="careerList[<s:property value="#row.index"/>].num"
							value="<s:property value='num'/>">
					</s:iterator>
				</tbody>
			</table>
		</div>

		<div id="eduView">
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
					<s:iterator value="educationList" status="row">
						<tr>
							<td><input type="text" id="eduInsititute"
								name="educationList[<s:property value="#row.index"/>].Institute"
								value="<s:property value='institute'/>"></td>
							<td><input type="date" id="eduStartDay"
								name="educationList[<s:property value="#row.index"/>].startDay"
								value="<s:property value='startDay'/>"></td>
							<td><input type="date" id="eduEndDay"
								name="educationList[<s:property value="#row.index"/>].endDay"
								value="<s:property value='endDay'/>"></td>
							<td><input type="text" id="eduContent"
								name="educationList[<s:property value="#row.index"/>].content"
								value="<s:property value='content'/>"></td>
							<td><input type='button' id='eRemove' value='삭제'
								onclick='eduRemove(this)' /></td>

						</tr>
						<input type="hidden"
							name="educationList[<s:property value="#row.index"/>].num"
							value="<s:property value='num'/>">

					</s:iterator>
				</tbody>
			</table>
		</div>


		<label>관리자 여부</label> 
		<input type="checkBox" id="adminCk" name="adminCk"
		      <s:if test="%{mainVo.adminY != 0}">checked</s:if>  /> 
		      <input type="hidden" id="adminY" name="mainVo.adminY"
			value="<s:if test='%{mainVo.adminY !=0}'>1</s:if><s:else>0</s:else>" >

		<span id="pwView" style='display: none' >
			<input type="password" id="adminPw" name="mainVo.adminPw"
			value="${mainVo.adminPw }" />
		</span>

		<div>
			<input type="button" id="cancel" value="취소" 	onclick="backConfirm()"> 
				<input type="button" id="insBtn" value="확인" onclick="inSuccess()">
		</div>


		<!-- 세션의 empNo와 현재 페이지의 empNo비교 (본인꺼면 empNoPw 창이 보이도록) -->
		<input type="hidden" id="sessionEmpNo" name="sessionEmpNo"
			value="${sessionScope.empNo }"> 
			<input type="hidden" id="nowEmpNo" name="nowEmpNo" value="${mainVo.empNo }">


		<!-- js로 넘길 사이즈값 -->
		<input type="hidden" id="schoolSize" name="schoolSize"
			value="${schoolSize }" /> <input type="hidden" id="careerSize"
			name="careerSize" value="${careerSize }" /> <input type="hidden"
			id="certificationSize" name="certificationSize"
			value="${certificationSize }" /> <input type="hidden"
			id="educationSize" name="educationSize" value="${educationSize }" />
	</form>

</body>
</html>


var school;
var certi;
var career;
var edu;
var sessionEmpNo;
var nowEmpNo;

$(document).ready(function() {
	school = parseInt($('#schoolSize').val());
	certi = parseInt($('#certificationSize').val());
	career = parseInt($('#careerSize').val());
	edu = parseInt($('#educationSize').val());

	sessionEmpNo = $('#sessionEmpNo').val();
	nowEmpNo = $('#empNo').val();
	
	
	//관리자 초기셋팅
	if($('#adminY').val()==1 && sessionEmpNo==nowEmpNo){
		$('#adminCk').attr("disabled", "disabled");  //본인이 관리자 해제 불가하도록
		pwView.style.display = 'block'; //본인정보 암호수정창 보이도록
		
	}
	//관리자 내용변경시
	// 체크박스값 넘기기 위함(관리자여부)_선택시 세션empNo와 선택한 empNo가 일치하면 비번수정창 나오도록
	$('#adminCk').change(function() {
		if ($('#adminCk').is(":checked")) {
			$('#adminY').val("1");
			
			if (sessionEmpNo == nowEmpNo) {
				pwView.style.display = 'block';
			}else{
				$('#adminPw').val("0000");
			}
		} else {
			$('#adminY').val("0");
			
			pwView.style.display = 'none';

		}
	});

	//상태 초기셋팅
	if($('#stateY').val()!=0){
		state.style.display = 'block';
	}else{
		state.style.display = 'none';
	}
	
	//상태 내용변경시
	$('#stateY').change(function() {
		var opt = $('#stateY').val();
		if (opt =='1' || opt =='2') {
			state.style.display = 'block';

		}else{
			state.style.display = 'none';
			$('#stateDate').val('');
		}
	})
});


function listBackConfirm(){	  
	  var con = confirm("이페이지를 벗어나면 작성중인 내용이 저장되지 않습니다. 이동하시겠습니까 ?");	  
	  if(con){
		  location.href='eList.action';
	  }else{
		  return;
	  }
}


function backConfirm(){
	 var con = confirm("이페이지를 벗어나면 작성중인 내용이 저장되지 않습니다. 취소하시겠습니까 ?");	  
	  if(con){
		  location.href='eView.action?empNo='+nowEmpNo;
	  }else{
		  return;
	  }
}

// 학력 추가 이벤트
function schoolPlus() {
	var rowItem = "<tr>"
	rowItem += "<td><input type='date' id='scStartDay' name='schoolList["
			+ school + "].startDay' ></td>"
	rowItem += "<td><input type='date' id='scEndDay' name='schoolList["
			+ school + "].endDay'> </td>"
	rowItem += "<td><input type='text'  id='schoolName' name='schoolList["
			+ school + "].schoolName'></td>"
	rowItem += "<td><input type='text'  id='major' name='schoolList[" + school
			+ "].major'></td>"
	rowItem += "<td><input type='button' id='sRemove'name='sRemove' value='삭제' onclick='schoolRemove(this)'/></td>"
	rowItem += "</tr>"
	$('#schoolTable').append(rowItem);
	school++;
}

// 자격증 추가 이벤트
function certiPlus() {
	var rowItem = "<tr>"
	rowItem += "<td><input type='date' id='acpDate' name='certificationList["
			+ certi + "].acpDate' ></td>"
	rowItem += "<td><input type='text'  id='certificationName' name='certificationList["
			+ certi + "].certificationName'/></td>"
	rowItem += " <td><input type='text'  id='agency' name='certificationList["
			+ certi + "].agency'/></td>"
	rowItem += "<td><input type='button' id='cRemove' value='삭제' onclick='certiRemove(this)'/></td>"
	rowItem += "</tr>"
	$('#certiTable').append(rowItem);
	certi++;
}

// 경력 추가 이벤트
function careerPlus() {
	var rowItem = "<tr>"
	rowItem += "<td><input type='text'  id='carEmp' name='careerList[" + career
			+ "].beforeEmp'></td>"
	rowItem += "<td><input type='date' id='carStartDay' name='careerList["
			+ career + "].startDay' ></td>"
	rowItem += "<td><input type='date' id='carEndDay' name='careerList["
			+ career + "].endDay'> </td>"
	rowItem += "<td><input type='text'  id='carTitle' name='careerList["
			+ career + "].title'></td>"
	rowItem += "<td><input type='text'  id='carwork' name='careerList["
			+ career + "].beforeWork'></td>"
	rowItem += "<td><input type='text'  id='carRetirement' name='careerList["
			+ career + "].retirement'></td>"
	rowItem += "<td><input type='button' id='rRemove' value='삭제' onclick='careerRemove(this)'/></td>"
	rowItem += "</tr>"
	$('#careerTable').append(rowItem);
	career++;
}

// 교육 추가 이벤트
function eduPlus() {
	var rowItem = "<tr>"
	rowItem += "<td><input type='text'  id='eduInsititute' name='educationList["
			+ edu + "].Institute'></td>"
	rowItem += "<td><input type='date' id='eduStartDay' name='educationList["
			+ edu + "].startDay' ></td>"
	rowItem += "<td><input type='date' id='eduEndDay' name='educationList["
			+ edu + "].endDay'> </td>"
	rowItem += "<td><input type='text' id='eduContent' name='educationList["
			+ edu + "].content'></td>"
	rowItem += "<td><input type='button' id='eRemove' value='삭제' onclick='eduRemove(this)'/></td>"
	rowItem += "</tr>";
	$('#eduTable').append(rowItem);
	edu++;

}
// 삭제버튼들 이벤트
function schoolRemove(obj) {
	var con = confirm("삭제 시 해당 행에 작성한 내용이 저장되지 않습니다. 삭제하시겠습니까?");	  
	  if(con){
	var tr = $(obj).parent().parent();
	tr.remove();
	  }else{
		  return;
	  }
}

function certiRemove(obj) {
	var con = confirm("삭제 시 해당 행에 작성한 내용이 저장되지 않습니다. 삭제하시겠습니까?");	  
	  if(con){
	var tr = $(obj).parent().parent();
	tr.remove();
	  }else{
		  return;
	  }
}

function careerRemove(obj) {
	var con = confirm("삭제 시 해당 행에 작성한 내용이 저장되지 않습니다. 삭제하시겠습니까?");	  
	  if(con){
	var tr = $(obj).parent().parent();
	tr.remove();
	  }else{
		  return;
	  }
}

function eduRemove(obj) {
	var con = confirm("삭제 시 해당 행에 작성한 내용이 저장되지 않습니다. 삭제하시겠습니까?");	  
	  if(con){
	var tr = $(obj).parent().parent();
	tr.remove();
	  }else{
		  return;
	  }
}

// 주민번호, 이메일 합치기
function inSuccess() {
	//not null인 값들 공백&유효값 체크
	//정규식
	var regNum =/^[0-9]+$/;  //숫자만
	var regName =/^[가-힣a-zA-Z]{2,15}$/;  //한글영어만
	var regEmail =/^[a-zA-Z0-9]+$/; //영어숫자만
	
	  //이름
		if($.trim($('#name').val()) == "" || $.trim($('#name').val()) == null){
			alert("사원명을 입력해주세요.");
			$('#name').focus();
			return false;
		}else if(!regName.test($.trim($('#name').val()))){
			alert("[사원명오류] 2글자 이상 한글이나 영어만 입력해주세요.")
			$('#name').focus();
			return false;
		}		
		
		//주민번호
		if($.trim($('#jumin1').val()) == ""||$.trim($('#jumin1').val()) == null){
			alert('주민번호 앞자리를 입력해주세요.');
			$('#jumin1').focus();
			return false;
		}else if(!regNum.test($.trim($('#jumin1').val())) || $.trim($('#jumin1').val()).length != 6 ){
			alert('[주민번호 앞자리오류] 6자리의 숫자만 입력해주세요.');
			$('#jumin1').focus();
			return false;
		}
		if($.trim($('#jumin2').val()) == ""||$.trim($('#jumin2').val()) == null){
			alert('주민번호 뒷자리를 입력해주세요.');
			$('#jumin2').focus();
			return false;
		}else if(!regNum.test($.trim($('#jumin2').val())) || $.trim($('#jumin2').val()).length != 7 ){
			alert('[주민번호 뒷자리오류] 7자리의 숫자만 입력해주세요.');
			$('#jumin2').focus();
			return false;
		}				
	
		//입사일
		if($.trim($('#hiredate').val()) == ""||$.trim($('#hiredate').val()) == null){
			alert('입사일을 입력해주세요.');
			$('#hiredate').focus();
			return false;
		}			
	
		//연락처
		if($.trim($('#phone1').val()) == ""||$.trim($('#phone1').val()) == null){
			alert('연락처를 모두 입력해주세요.');
			$('#phone1').focus();
			return false;
		}else if($.trim($('#phone2').val()) == ""||$.trim($('#phone2').val()) == null){
			alert('연락처를 모두 입력해주세요.');
			$('#phone2').focus();
			return false;
		}else if($.trim($('#phone3').val() == ""||$('#phone3').val()) == null){
			alert('연락처를 모두 입력해주세요.');
			$('#phone3').focus();
			return false;
		}else if(!regNum.test($.trim($('#phone1').val())) || $.trim($('#phone1').val()).length != 3 ){
			alert('[연락처 오류] 형식에 맞지 않습니다.');
			$('#phone1').focus();
			return false;
		}else if(!regNum.test($.trim($('#phone2').val())) ||
				   $.trim($('#phone2').val()).length>4 ||  $.trim($('#phone2').val()).length < 3){
			alert('[연락처 오류] 형식에 맞지 않습니다.');
			$('#phone2').focus();
			return false;
		}else if(!regNum.test($.trim($('#phone3').val())) || $.trim($('#phone3').val()).length != 4 ){
			alert('[연락처 오류] 형식에 맞지 않습니다.');
			$('#phone3').focus();
			return false;
		}
		
	
		//이메일
		if($.trim($('#email1').val()) == ""||$.trim($('#email1').val()) == null){
			alert('이메일을 모두 입력해주세요.');
			$('#email1').focus();
			return false;
		}else if($.trim($('#email2').val()) == ""||$.trim($('#email2').val()) == null){
			alert('이메일을 모두 입력해주세요.');
			$('#email2').focus();
			return false;
		}else if(!regEmail.test($.trim($('#email1').val()))){
			alert('[이메일 오류] 형식에 맞지 않습니다.');
			$('#email1').focus();
			return false;
		}	
		//부서
		if($.trim($('#dept').val()) == ""||$.trim($('#dept').val()) == null){
			alert('부서를 선택해주세요.');
			$('#dept').focus();
			return false;
		}
		//직책
		if($.trim($('#jobTitle').val()) == ""||$.trim($('#jobTitle').val()) == null){
			alert('직책을 선택해주세요.');
			$('#jobTitle').focus();
			return false;
		}
		
		if($('#stateY').val()==1 && $('#stateDate').val() =="" ||$('#stateDate').val() ==null ){
			alert("휴직일자를 입력해주시기바랍니다.");
			return;
		}
		
		if($('#stateY').val()==2 && $('#stateDate').val() =="" ||$('#stateDate').val() ==null ){
			alert("퇴직일자를 입력해주시기바랍니다.");
			return;
		}
		
	var phone1 = $('#phone1').val();
	var phone2 = $('#phone2').val();
	var phone3 = $('#phone3').val();
	var j = '-';
	var phone = phone1 + j + phone2 + j + phone3;
	$('#phone').val(phone);

	var jumin1 = $('#jumin1').val();
	var jumin2 = $('#jumin2').val();
	var j = '-';
	var jumin = jumin1 + j + jumin2;
	$('#residentNum').val(jumin);

	var email1 = $('#email1').val();
	var email2 = $('#email2').val();
	var j = '@';
	var email = email1 + j + email2;
	$('#email').val(email);

	$('#insForm').submit();
}

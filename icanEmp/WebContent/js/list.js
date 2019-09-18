//로그아웃 확인 이벤트
  function logoutConfirm(){	  
	  var con = confirm("로그아웃 하시겠습니까 ?");	  
	  if(con){
		  location.href='eLogout.action';
	  }else{
		  return;
	  }
  }
  
  //재직자만 조회의 체크박스값 넘기기 위함
$(document).ready(function(){

	
	$('#checkR').change(function(){
		if($('#checkR').is(":checked")){
			$("#retiree").val("reti");
		
		}else{
			$("#retiree").val("all");
		}
		$('#listForm').submit();
		
	});
	
	
	
	if($('#select').val() == "dept"){
		deptS.style.display = 'block';
		jobS.style.display = 'none';
		search.style.display = 'none';
		
	}else if($('#select').val() == "jobTitle"){
		jobS.style.display = 'block';
		deptS.style.display = 'none';
		search.style.display = 'none';
		
	}else{
		jobS.style.display = 'none';
		deptS.style.display = 'none';
		search.style.display = 'block';
    }
	
	//부서or직책 선택 시 서브select문 나오도록
	$('#select').change(function(){
		var opt = $('#select').val();
		if(opt == "dept"){
			deptS.style.display = 'block';
			jobS.style.display = 'none';
			search.style.display = 'none';
		}else if(opt == "jobTitle"){
			jobS.style.display = 'block';
			deptS.style.display = 'none';
			search.style.display = 'none';
		}else{
			jobS.style.display = 'none';
			deptS.style.display = 'none';
			search.style.display = 'block';
		}
		
	})
	
	
});


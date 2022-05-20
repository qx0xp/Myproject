$(document).ready(function(){
	// 필수 : 아이디, 비밀번호, 닉네임, 이메일, 연락처
	var idOkay=false;
	var pwOkay=false;
	var nameOkay=false;
	var emailOkay=false;
	var telOkay=false;
	
	// 아이디 유효성 검사
	// 5~20자의 영문 소문자, 숫자와 특수기호_, - 만
	$("#id").on("blur", function(){
		idOkay=false;
		var idReg=/^[a-z0-9-_]{5,20}$/;
		
		if($("#id").val()==""){
			$("#id_msg").text("*필수 정보입니다.");
			return false;
		}
		
		if(!idReg.test($("#id").val())){
			$("#id_msg").text("5~20자리의 영어 소문자, 숫자, 특수문자 -,_만 가능합니다.");
			$("#id").focus();
			return false;
		}
		
		if(checkId()==1){
			$("#id_msg").text("이미 존재하는 아이디입니다.");
			return false;
		} else{
			$("#id_msg").text("사용할 수 있는 아이디입니다.");
			idOkay=true;
		}
	})
	
	// 비밀번호 유효성 검사
	// 8~16자 최소 영문 대소문자 1개, 숫자 1개, 특수문자 1번씩
	$("#pw1").on("blur", function(){
		var pwReg=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;
		
		if($("#pw1").val()==""){
			$("#pw1_msg").text("*필수 정보입니다.");
			return false;
		}
		
		if(pwReg.test($("#pw1").val())){
			$("#pw1_msg").text("");
		} else{
			$("#pw1_msg").text("8~16자 영문 대소문자, 숫자, 특수문자 조합이 필요합니다.");
			$("#pw1").focus();
			return false;
		}
	})
	
	// 비밀번호 확인 유효성 검사
	$("#pw2").on("blur", function(){
		if($("#pw2").val()==""){
			$("#pw2_msg").text("*필수 정보입니다.");
			return false;
		}
		
		if($("#pw1").val()!=$("#pw2").val()){
			$("#pw2_msg").text("비밀번호가 일치하지 않습니다.");
			$("#pw2").focus();
			return false;
		} else{
			$("#pw2_msg").text("");
			pwOkay=true;
		}
	})
	
	// 이름 유효성 검사
	$("#name").on("blur", function(){
		if($("#name").val()==""){
			$("#name_msg").text("*필수 정보입니다.");
			return false;
		} else{
			$("#name_msg").text("");
			nameOkay=true;
		}
	})
	
	// 이메일 유효성 검사
	$("#email").on("blur", function(){
		/* '시작을'  0~9 사이 숫자 or a-z A-Z 알바펫 아무거나로 시작하고  /  중간에 - _  . 같은 문자가 있을수도 있고 없을수도 있으며 / 
		그 후에 0~9 사이 숫자 or a-z A-Z 알바펫중 하나의 문자가 없거나 연달아 나올수 있으며 /  @ 가 반드시 존재하고  / 
		0-9a-zA-Z 여기서 하나가 있고  /  중간에 - _  . 같은 문자가 있을수도 있고 없을수도 있으며 / 그 후에 0~9 사이 숫자 or a-z A-Z 알바펫중 하나의 
		문자가 없거나 연달아 나올수 있으며 /  반드시  .  이 존재하고  / [a-zA-Z] 의 문자가 2개나 3개가 존재 / 대소문자 구분 안 함 */
		var emReg=/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
		if($("#email").val()==""){
			$("#email_msg").text("*필수 정보입니다.");
			return false;
		}
		
		if(emReg.test($("#email").val())){
			$("#email_msg").text("");
			emailOkay=true;
		} else{
			$("#email_msg").text("양식에 맞게 입력해주세요.");
			$("#email").focus();
			return false;
		}
	})
	
	// 연락처 유효성 검사
	$("#tel").on("blur", function(){
		
		var telReg=/^\d{3}-\d{3,4}-\d{4}$/;
		
		if($("#tel").val()==""){
			$("#tel_msg").text("*필수 정보입니다.");
			return false;
		}
		
		if(telReg.test($("#tel").val())){
			$("#tel_msg").text("");
			telOkay=true;
		} else{
			$("#tel_msg").text("양식에 맞게 입력해주세요.");
			$("#tel").focus();
			return false;
		}
	})
	
	// 날짜 유효성 검사
	$("#birth").on("blur", function(){
		var birthReg=/^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1,2][0-9]|3[0-1])$/;
		
		if(birthReg.test($("#birth").val())){
			$("#birth_msg").text("");
		} else{
			$("#birth_msg").text("정말이세요?");
			$("#birth").focus();
			return false;
		}
	})
	
	// 가입하기 버튼 툴렀을 때
	$("#joinBtn").click(function(){
		if(idOkay==true&&
			pwOkay==true&&
			nameOkay==true&&
			emailOkay==true&&
			telOkay==true){
			$("#joinForm").submit();
		} else{
			alert("다시 입력하세요");
		}
	})
})

// 아이디 중복 검사
function checkId(){
	var id=$("#id").val(); // id 입력값 저장
	var rs;
	
	$.ajax({
		type:"get",
		url:"/checkId/"+id,
		data:{id:id}, // 서버측 전송
		dataType:"json",
		async: false, // 동기식 변경
		success:function(result){
			rs=result;
		},
		error:function(){
			alert("아이디를 입력하세요.");
		}
	})
	
	return rs;
}
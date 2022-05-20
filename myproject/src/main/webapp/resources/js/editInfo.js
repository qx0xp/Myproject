$(document).ready(function(){
	$("#editBtn").on("click", function(){
		if(checkForm()==true){
			$("#editForm").submit();
		} else {
			alert("다시 입력하세요.");
		}
	})
})

function checkForm(){
	var idReg=/^[a-z0-9-_]{5,20}$/;
	var pwReg=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,16}$/;
	var emReg=/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	var telReg=/^\d{3}-\d{3,4}-\d{4}$/;
	var birthReg=/^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1,2][0-9]|3[0-1])$/;
	
	if($("#id").val()==""){
		$("#id_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if(!idReg.test($("#id").val())){
		$("#id_msg").text("5~20자리의 영어 소문자, 숫자, 특수문자 -,_만 가능합니다.");
		$("#id").focus();
		return false;
	}
	
	if($("#pw1").val()==""){
		$("#pw1_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if(!pwReg.test($("#pw1").val())){
		$("#pw1_msg").text("8~16자 영문 대소문자, 숫자, 특수문자 조합이 필요합니다.");
		$("#pw1").focus();
		return false;
	}
	
	if($("#pw2").val()==""){
		$("#pw2_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if($("#pw1").val()!=$("#pw2").val()){
		$("#pw2_msg").text("비밀번호가 일치하지 않습니다.");
		$("#pw2").focus();
		return false;
	}
	
	if($("#name").val()==""){
		$("#name_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if($("#email").val()==""){
		$("#email_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if(!emReg.test($("#email").val())){
		$("#email_msg").text("양식에 맞게 입력해주세요.");
		$("#email").focus();
		return false;
	}
	
	if($("#tel").val()==""){
		$("#tel_msg").text("*필수 정보입니다.");
		return false;
	}
	
	if(!telReg.test($("#tel").val())){
		$("#tel_msg").text("양식에 맞게 입력해주세요.");
		$("#tel").focus();
		return false;
	}
	
	if(!birthReg.test($("#birth").val())){
		$("#birth_msg").text("정말이세요?");
		$("#birth").focus();
		return false;
	}
	
	return true;
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../resources/css/join.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../resources/js/join.js"></script>
</head>
<body>
    <div class="wrap">
		<h2>JOIN</h2>
		<div class="content">
            <form action="/join" id="joinForm" method="post">
                <div class="box">
                    <h3><label for="id">아이디</label></h3>
                    <input type="text" name="id" id="id" class="int" required>
                    <p class="msg" id="id_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="pw1">비밀번호</label></h3>
                    <input type="password" name="password" id="pw1" class="int" required>
                    <p class="msg" id="pw1_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="pw2">비밀번호 재확인</label></h3>
                    <input type="password" id="pw2" class="int" required>
                    <p class="msg" id="pw2_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="name">닉네임</label></h3>
                    <input type="text" name="name" id="name" class="int" required>
                    <p class="msg" id="name_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="email">이메일</label></h3>
                    <input type="text" name="email" id="email" class="int" required>
                    <p class="msg" id="email_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="tel">연락처</label></h3>
                    <input type="text" name="tel" id="tel" class="int" placeholder="예) 010-1111-xxxx" maxlength="13" required>
                    <p class="msg" id="tel_msg"></p>
                </div>
                 <div class="box">
                    <h3><label for="birth">생년월일(선택)</label></h3>
                    <input type="text" name="birth" id="birth" class="int" placeholder="예) 1991-01-01" maxlength="10">
                    <p class="msg" id="birth_msg"></p>
                </div>
                <div class="box">
                    <h3><label for="gender">성별(선택)</label></h3>
                    <select name="gender" id="gender" class="int">
                    	<option value="" disabled selected>성별</option>
                        <option value="남">남자</option>
                        <option value="여">여자</option>
                        <option value="">선택 안함</option>
                    </select>
                </div>
                <div class="box btn_area">
                    <input type="button" class="btn" id="joinBtn" value="가입하기">
                </div>
            </form>
        </div>
	</div>
</body>
</html>
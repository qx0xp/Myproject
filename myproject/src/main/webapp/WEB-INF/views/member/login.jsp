<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- 구글 웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<!-- css -->
<link rel="stylesheet" href="../resources/css/login.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="wrap">
		<%@include file="../header.jsp" %>
	    <div id="content">
	        <h2>LOGIN</h2>
	        <form action="/login" method="post">
	            <div>
	                <input type="text" name="id" class="id" placeholder="아이디"><br>
	                <input type="password" name="password" class="password" placeholder="비밀번호">
	            </div>
	            <div><label class="check"><input type="checkbox" class="check">아이디저장</label></div>
	            <div><input type="submit" class="loginBtn" value="로그인"></div>
	            <div class="user_info">
	                <a href="/join">회원가입</a>
	                <ul>
	                    <li><a href="#">아이디찾기</a></li>
	                    <li><a href="#">비밀번호찾기</a></li>
	                </ul>
	            </div>
	        </form>
	    </div>
	    <%@include file="../footer.jsp" %>
	</div>
</body>
</html>
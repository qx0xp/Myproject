<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="../resources/css/deleteAccount.css">
</head>
<body>
    <div id="wrap">
    	<%@include file="../header.jsp" %>
		<div class="content">
		    <h2 class="delete_title">회원탈퇴</h2>
            <div class="delete_memo">
		                회원탈퇴를 원하시면 비밀번호를 입력하신 후, 회원탈퇴 버튼을 클릭해주세요.<br>
		                탈퇴하시면 회원정보가 데이터베이스에서 완전히 삭제됩니다.
            </div>
			<form action="/deleteAccount" id="deleteForm" method="post">
                <div class="delete_area">
                    <ul>
                        <li>
                            <p class="delete_item">아이디</p>
                            <p class="delete_value"><input type="text" name="id" value="${login.id}" readonly></p>
                        </li>
                        <li>
                            <p class="delete_item">비밀번호</p>
						    <p class="delete_value"><input type="text" name="password" id="password"></p>
						</li>
                    </ul>
                </div>

                <div class="delete_option">
                    <input type="submit" class="deleteBtn" onclick="/deleteAccount" value="탈퇴하기">
				    <input type="button" class="cancelBtn" onclick="/mypage" value="취소하기">
                </div>
			</form>
			
			<c:if test="${msg==false}">
	            <div class="delete_msg">
	                 <p>비밀번호가 맞지 않습니다. 다시 확인해주세요.</p>
	            </div>
            </c:if>
		</div>
		<%@include file="../footer.jsp" %>
	</div>
</body>
</html>
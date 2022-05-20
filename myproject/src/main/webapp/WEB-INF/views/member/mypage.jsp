<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="../resources/css/mypage.css">
</head>
<body>
	<div id="wrap">
        <div class="content">
            <h2 class="profile_title">내 프로필</h2>
            <div class="profile_header">
                <p class="pro_img"><img src="../resources/img/profile_img.png" alt="프로필 이미지"></p>
            </div>
            <div class="profile_area">
                <ul>
                    <li>
                        <p class="pro_item">아이디 :</p>
                        <p class="pro_detail">${login.id}</p>
                    </li>
                    <li>
                        <p class="pro_item">비밀번호 :</p>
                        <p class="pro_detail">${login.password}</p>
                    </li>
                    <li>
                        <p class="pro_item">닉네임 :</p>
                        <p class="pro_detail">${login.name}</p>
	                </li>
                    <li>
                        <p class="pro_item">이메일 :</p>
                        <p class="pro_detail">${login.email}</p>
                    </li>
                    <li>
                        <p class="pro_item">연락처 :</p>
                        <p class="pro_detail">${login.tel}</p>
                    </li>
                    <li>
                        <p class="pro_item">생년월일 :</p>
                        <p class="pro_detail">${login.birth}</p>
                    </li>
                    <li>
                        <p class="pro_item">성별 :</p>
                        <p class="pro_detail">${login.gender}</p>
                    </li>
                </ul>
            </div>
            <div class="profile_option">
                <input type="submit" class="pro_modifyBtn" value="회원정보 수정" onclick="location.href='/editInfo'">
                <input type="button" class="pro_deleteBtn" value="회원탈퇴" onclick="location.href='/deleteAccount'">
            </div>
        </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="../resources/css/editInfo.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../resources/js/editInfo.js"></script>
</head>
<body>
    <div id="wrap">
        <div class="content">
        <h2 class="profile_title">내 프로필</h2>
            <div class="profile_area">
            	<form action="/editInfo" id="editForm" method="post">
	            	<div class="profile_header">
	                	<p class="pro_img">
	                		<img src="../resources/img/profile_img.png" alt="프로필 이미지">
	                	</p>
	            	</div>
	                <ul>
	                    <li>
	                        <span class="pro_item">아이디 :</span>
	                        <span class="pro_detail"><input type="text" class="int" name="id" value="${login.id}" readonly></span>
	                    </li>
	                    <li>
	                        <span class="pro_item">비밀번호 :</span>
	                        <span class="pro_detail"><input type="password" class="int" id="pw1" name="password" required></span>
	                        <p class="msg" id="pw1_msg"></p>
	                    </li>
						<li>
	                        <span class="pro_item">비밀번호 재확인:</span>
	                        <span class="pro_detail"><input type="password" class="int" id="pw2" required></span>
	                        <p class="msg" id="pw2_msg"></p>
	                    </li>
	                    <li>
	                        <span class="pro_item">닉네임 :</span>
	                        <span class="pro_detail"><input type="text" class="int" id="name" name="name" value="${login.name}" required></span>
	                        <p class="msg" id="name_msg"></p>
	                    </li>
	                    <li>
	                        <span class="pro_item">이메일 :</span>
	                        <span class="pro_detail"><input type="text" class="int" id="email" name="email" value="${login.email}" required></span>
	                        <p class="msg" id="email_msg"></p>
	                    </li>
	                    <li>
	                        <span class="pro_item">연락처 :</span>
	                        <span class="pro_detail"><input type="text" class="int" id="tel" name="tel" value="${login.tel}" required></span>
	                        <p class="msg" id="tel_msg"></p>
	                    </li>
	                    <li>
	                        <span class="pro_item">생년월일 :</span>
	                        <span class="pro_detail"><input type="text" class="int" id="birth" name="birth" value="${login.birth}"></span>
	                        <p class="msg" id="birth_msg"></p>
	                    </li>
	                    <li>
	                        <span class="pro_item">성별 :</span>
	                        <span class="pro_detail">
				            	<select name="gender" id="gender" class="int">
			                        <option value="남" ${login.gender eq '남'?'selected':''}>남자</option>
			                        <option value="여" ${login.gender eq '여'?'selected':''}>여자</option>
			                        <option value="">선택 안함</option>
			                    </select>
	                        </span>
	                    </li>
	                </ul>
                </form>
            </div>
            <div class="profile_option">
		    	<input type="button" id="editBtn" class="pro_editBtn" value="완료">
		    </div>
        </div>
    </div>
</body>
</html>
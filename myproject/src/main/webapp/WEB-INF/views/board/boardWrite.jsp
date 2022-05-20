<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NOTICE</title>

<!-- 웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="../../resources/css/boardWrite.css">

<!-- js -->
<script src="../../resources/js/jquery.js"></script>
<script src="../../resources/js/attachFile.js"></script>
</head>
<body>
    <div class="main">
        <h2>게시판 글쓰기</h2>
        <form action="/board/write" method="post" class="mainForm">
            <table>
                <tr><td>
                    <select name="bgno">
                        <option value="1" ${bgno eq '1'?'selected':''}>공지사항</option>
                        <option value="2" ${bgno eq '2'?'selected':''}>영화소식</option>
                        <option value="3" ${bgno eq '3'?'selected':''}>영화리뷰</option>
                        <option value="4" ${bgno eq '4'?'selected':''}>영화수다</option>
                        <option value="5" ${bgno eq '5'?'selected':''}>자유수다</option>
                        <option value="6" ${bgno eq '6'?'selected':''}>나눔</option>
                    </select>
                </td></tr>
                <tr><td>
                        <input type="text" name="title" placeholder="제목을 입력하세요">
                        <input type="hidden" name="id" value="${login.id}">
                        <input type="hidden" name="writer" value="${login.name}">
                </td></tr>
                <tr><td><input type="file" name="uploadFile" id="uploadFile" class="b_uploadFile" multiple></td></tr>
                <tr><td><textarea name="content" rows="20"></textarea></td></tr>
                <tr><td><div id="preview"><ul></ul></div></td></tr>
                <tr><td><input type="button" id="uploadBtn" class="b_uploadBtn" value="등록"></td></tr>
            </table>
        </form>
    </div>
</body>
</html>
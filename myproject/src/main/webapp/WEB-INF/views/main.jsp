<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 구글 웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<!-- css -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<link rel="stylesheet" href="../../resources/css/style.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!--slick-->
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="../../resources/js/script.js"></script>
<title>main</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
            <div id="headerIn">
                <h1 class="logo"><a href="#">In the mood for Movies</a></h1>
                <div class="util">
                	<c:if test="${login==null}"><a href="/login" class="h_login">login</a></c:if>
                    <c:if test="${login!=null}">
                    	<a href="/mypage" class="h_mypage">마이페이지</a>
                        <a href="/logout" class="h_logout">로그아웃</a>
                    </c:if>
                    <ul>
                        <li class="h_search"><a href="#">search</a></li>
                        <li class="h_menu"><a href="#">menu</a></li>
                    </ul>
                </div>
            </div> <!--.headerIn-->
		</header> <!--#header -->
            
		<div id="container">
            <section class="main1">
                <div class="slides">
                    <div class="slide"><img src="../../resources/img/slide1.jpg"></div>
                    <div class="slide"><img src="../../resources/img/slide4.jpg"></div>
                    <div class="slide"><img src="../../resources/img/slide5.jpg"></div>
                </div>
            </section> <!--.main1-->
            
            <section class="main2">
            	<div class="list_header">
            		<h2>인기글 보기</h2>
            	</div>
                <div class="list_area">
                    <ul>
                        <c:forEach items="${blist}" var="blist">
                            <li class="list_content">
                                <div class="board_title"><a href="/board/detail?bno=${blist.bno}">${blist.title}</a></div>
                                <div class="board_good">${blist.good}</div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
            
            <section class="main3">
            	<div class="list_box">
	            	<div class="list_header">
	            		<h2>영화 소식</h2>
	            	</div>
	                <div class="list_area">
	                    <ul>
	                        <c:forEach items="${nlist}" var="nlist">
	                            <li class="list_content">
	                                <div class="board_title"><a href="/board/detail?bno=${nlist.bno}">${nlist.title}</a></div>
	                            </li>
	                        </c:forEach>
	                    </ul>
	                </div>
            	</div>
				<div class="list_box">
	            	<div class="list_header">
	            		<h2>영화 수다</h2>
	            	</div>
	                <div class="list_area">
	                    <ul>
	                        <c:forEach items="${tlist}" var="tlist">
	                            <li class="list_content">
	                                <div class="board_title"><a href="/board/detail?bno=${tlist.bno}">${tlist.title}</a></div>
	                            </li>
	                        </c:forEach>
	                    </ul>
	                </div>
            	</div>
            </section>
            
        </div> <!--#container-->
        
        <footer id="footer">
            <div class="f_copyright">Copyright© In the mood for Movies All rights reserved.</div>
        </footer> <!--#footer-->
        <div class="top"><a href="#">top</a></div>
        <div class="side">
            <div class="side_close"><a href="#">닫기</a></div>
            <div class="side_box">
                <ul>
                    <li><a href="/board?bgno=1">공지사항</a></li>
                </ul>
                <span class="bar"></span>
                <ul>
                    <li><a href="/board?bgno=2">영화소식</a></li>
                    <li><a href="/board?bgno=3">영화리뷰</a></li>
                    <li><a href="/board?bgno=4">영화수다</a></li>
                </ul>
                <span class="bar"></span>
                <ul>
                    <li><a href="/board?bgno=5">자유수다</a></li>
                    <li><a href="/board?bgno=6">나눔</a></li>
                </ul>
            </div>
        </div> <!--.side-->
	</div> <!--#wrap-->
</body>
</html>
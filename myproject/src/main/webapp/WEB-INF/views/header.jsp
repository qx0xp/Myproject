<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	#header{
    position: relative;
    height: 60px;
    background-color: #fff;
}

#headerIn{
    height: 60px;
}

.logo{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}

.logo a{
    display: block;
    height: 35px;
    line-height: 35px;
    color: #000;
    font-size: 20px;
}

.util .h_login{
    position: absolute;
    left: 15px;
    top: 15px;
    text-indent: -99999px;
    width: 30px;
    height: 30px;
    background-image: url("../../resources/img/h_login.png");
    background-size: 20px auto;
    background-repeat: no-repeat;
    background-position: center;
}

.util .h_mypage{
    position: absolute;
    left: 15px;
    top: 15px;
    text-indent: -99999px;
    width: 30px;
    height: 30px;
    background-image: url("../../resources/img/h_mypage.png");
    background-size: 20px auto;
    background-repeat: no-repeat;
    background-position: center;
}

.util .h_logout{
    position: absolute;
    left: 55px;
    top: 15px;
    text-indent: -99999px;
    width: 30px;
    height: 30px;
    background-image: url("../../resources/img/h_logout.png");
    background-size: 20px auto;
    background-repeat: no-repeat;
    background-position: center;
}


.util ul{
    margin-right: 15px;
    margin-top: 15px;
    float: right;
    display: flex;
}

.util ul::after{
    content: '';
    display: block;
    clear: both;
}

.util li{
    margin-left: 5px;
}

.util li a{
    color: #222;
}

.util li>a{
    display: block;
    width: 30px;
    height: 30px;
    background-size: 20px auto;
    background-position: center;
    background-repeat: no-repeat;
    text-indent: -99999px;
}

.util .h_search a{background-image: url("../../resources/img/h_search.png");}
.util .h_login a{background-image: url("../../resources/img/h_login.png");}
.util .h_menu a{background-image: url("../../resources/img/h_menu.png");}

/* side */

.side{
    position: absolute;
    top: 0;
    right: -100%;
    height: 100vh;
    width: 100%;
    background-color: #eee;
    z-index: 600;
}

.side_close{
    position: absolute;
    top: 20px;
    right: 20px;
}

.side_close a{
    display: block;
    width: 60px;
    height: 60px;
    background-image: url("../../resources/img/side_close.png");
    background-size: 100% auto;
    text-indent: -99999px;
}

.side_box{
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.side_box ul::before{
    content: '';
    display: block;
    width: 30%;
    height: 10px;
    background-color: #222;
}

.side_box ul{
    margin: 20px 0;
}

.side li{
    margin: 10px 0;
}

.side li a{
    color: #222;
    font-size: 32px;
    font-weight: bold;
    line-height: 1.3em;
}

.side li a:hover{
    text-decoration: line-through;
    color: rgb(155, 9, 9)
}
</style>
<!-- js -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../../resources/js/common.js"></script>
</head>
<body>
	<header id="header">
            <div id="headerIn">
                <h1 class="logo"><a href="/main">In the mood for Movies</a></h1>
                <div class="util">
                	<c:if test="${login==null}"><a href="/login" class="h_login">login</a></c:if>
                    <c:if test="${login!=null}">
                    	<a href="/mypage" class="h_mypage">마이페이지</a>
                        <a href="/logout" class="h_logout">로그아웃</a>
                    </c:if>
                    <ul>
                        <li class="h_menu"><a href="#">menu</a></li>
                    </ul>
                </div>
            </div> <!--.headerIn-->
	</header> <!--#header -->
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
</body>
</html>
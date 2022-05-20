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
    background-image: url("../img/h_login.png");
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
    background-image: url("../img/h_mypage.png");
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
    background-image: url("../img/h_logout.png");
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

.util .h_search a{background-image: url("../img/h_search.png");}
.util .h_login a{background-image: url("../img/h_login.png");}
.util .h_menu a{background-image: url("../img/h_menu.png");}
	
</style>
</head>
<body>
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
</body>
</html>
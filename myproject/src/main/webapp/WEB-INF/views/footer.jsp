<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
#footer{
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 10px 0;
    background-color: #000;
    text-align: center;
    color: #fff;
    font-size: 20px;
    line-height: 1em;
}

.top{
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 40px;
    height: 40px;
    padding-top: 10px;
    border-radius: 50%;
    box-sizing: border-box;
    background-color: #eee;
    background-image: url('../../resources/img/top.png');
    background-size: 20px;
    background-repeat: no-repeat;
    background-position: center;
    text-indent: -99999px;
}

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
    background-image: url("../img/side_close.png");
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../../resources/js/script.js"></script>
</head>
<body>
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
</body>
</html>
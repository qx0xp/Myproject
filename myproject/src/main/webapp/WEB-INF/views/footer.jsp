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
	position: absolute;
	bottom: 0;
	width: 100%;
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
</style>
</head>
<body>
		<footer id="footer">
        	<div class="f_copyright">Copyright© In the mood for Movies All rights reserved.</div>
        </footer> <!--#footer-->
        <div class="top"><a href="#">top</a></div>
</body>
</html>
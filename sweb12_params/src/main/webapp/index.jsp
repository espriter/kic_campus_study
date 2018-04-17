<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
	* 요청시 정보 전달 연습 *<p/>
	<a href="kor/login?type=admin">관리자</a><br>
	<a href="kor/login?type=user">일반회원</a><br>
	<a href="kor/login">파라미터 없음</a><br>
	
	<hr>
	<form action="kor/seoul" method="post">
	data : <input type="text" name="type">
	<input type="submit" value="전송1">
	</form>
	
	<form action="kor/busan" method="post">
	data : <input type="text" name="type">
	<input type="submit" value="전송2">
	</form>
	
	<form action="kor/jeju" method="post">
	data : <input type="text" name="type">
	<input type="submit" value="전송3">
	</form>
	
	<hr>
	
	<form action="ent/sm/singer/psy" method="get">
	타이틀 송 : <input type="text" name="title">
	<input type="submit" value="전송4">
	</form>
	
	<form action="ent/yg/singer/bigbang" method="get">
	타이틀 송 : <input type="text" name="title">
	<input type="submit" value="전송5">
	</form>
	
	
	
	

	</body>
</html>















<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>상품 자료(Spring-legacy로 출력)</h2>
<table border="1">
	<tr>
		<th>고객번호</th><th>고객명</th><th>고객 전화</th>
	</tr>
	<c:forEach var="s" items="${message}">
	<tr>
		<td>${s.gogek_no}</td>
		<td>${s.gogek_name}</td>
		<td>${s.gogek_tel}</td>
	</tr>
	</c:forEach>
</table>		
	</body>
</html>

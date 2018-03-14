<%@page import="pack.business.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품자료</title>
</head>
<body>
<h2> ** 상품 자료 (MyBatis) ** </h2>
<a href="sangpum_ins.html">신상품 추가</a>
<Br>
<b>코드 클릭 시 삭제, 품명 클릭 시 수정 하기</b>
<% ArrayList<DataDto> list = (ArrayList)processDao.getDataAll(); %>
<table border="1">
	<tr><th>code</th><th>sang</th><th>su</th><th>dan</th></tr>
	<c:forEach var="s" items="<%=list %>">
	<tr>
		<td><a href="sangpum_del.jsp?code=${s.code}">${s.code}</a></td>
		<td><a href="sangpum_up.jsp?code=${s.code}">${s.sang}</td>
		<td>${s.su}</td>
		<td>${s.dan}</td>

	</tr>
	</c:forEach>
</table>
</body>
</html>
<%@page import="pack.business.DataDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 회원 정보(MyBatis) **</title>
</head>
<body>
<h2>** 회원 정보(MyBatis) **</h2>
<a href="ins.jsp">회원 추가</a>
<table border="1">
	<tr>
		<th>id</th><th>name</th><th>pwd</th><th>date</th></tr>
		<%
		ArrayList<DataDto> list = (ArrayList)processDao.selectDataAll();
		%>
		<c:set var="list" value="<%= list%>"/>
		<c:if test="${empty list}">
		<tr><td colspan="4">자료없음</td></tr>
		</c:if>
		<c:forEach var="m" items="<%=list %>">
		<tr>
			<td><a href="del.jsp?id=${m.id}">${m.id}</a></td>
			<td><a href="up.jsp?id=${m.id}">${m.name}</a></td>
			<td>${m.passwd }</td>
			<td>${f:substring(m.reg_date, 0,10)}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4">id 클릭은 삭제, name 클릭은 수정</td>
		</tr>
</table>
</body>
</html>
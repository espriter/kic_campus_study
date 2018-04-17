<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>${message}</h2>
		<br>
		${sangpumBean.sang } ${my.sang }
		
		<br>
		<%
		ArrayList<String> list = (ArrayList)request.getAttribute("myList");
		for(String s:list){
			out.print(s + "&nbsp;");
		}
		%>
		<br>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:forEach var="s" items="${myList }">
			${s}&nbsp;
		</c:forEach>
	</body>
</html>







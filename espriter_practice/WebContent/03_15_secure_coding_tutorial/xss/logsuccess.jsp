<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>인증된 페이지</h1>
<% String name = (String)session.getAttribute("namekey"); %>
<%= name %>님 환영합니다.
마음껏 권력을 누리십시오.
<a href="Logout.jsp">로그아웃</a>
</body>
</html>
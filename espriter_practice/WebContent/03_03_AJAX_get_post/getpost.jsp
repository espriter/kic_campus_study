<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String irum = request.getParameter("name");
String nai = request.getParameter("age");
out.println(irum + " 님의 나이는 " + nai + "살 입니다.");
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
서버 내용 호출(내장 객체 예제) : <br>
client ip : <%= request.getRemoteAddr() %><br>
client Domain : <%= request.getRemoteHost() %><br>
protocol : <%= request.getProtocol() %><br>
Method : <%= request.getMethod() %><br>
Server domain : <%= request.getServerName() %><br>
<br>
Server buffer size : <%= response.getBufferSize() %><br>
Server characterEncoding : <%= response.getCharacterEncoding() %><br>
<br>
context path : <%= application.getContextPath() %><br>
session : <%= pageContext.getSession() %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
결과는 
<br>
<%
String msg = (String)request.getAttribute("say");
out.println(msg + "이라고 말함");
%>
<br>
${requestScope.say } ${say }
</body>
</html>


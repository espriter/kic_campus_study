<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서블릿에 의해 호출된 파일입니다!<br>
<%
// < redirect 방식 >
//String data =request.getParameter("data");
//out.println("자료는(redirect 방식으로)" + data);

// < Forward 방식 >
String data = (String)request.getAttribute("test");
out.println("자료는(forward 방식으로)" + data);

%>
</body>
</html>
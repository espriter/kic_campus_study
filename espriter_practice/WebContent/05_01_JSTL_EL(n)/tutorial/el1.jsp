<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
환영합니다. EL 세상! <p/>
<%
if(request.getParameter("user") == null) {
%>
	<jsp:forward page="el1.html"/>
<%	
}
%>
<br>
결과출력<br>
기존방식 : <%=request.getParameter("user") %> <!-- el1.html에서 user 값을 불러옴 -->
<%out.println(request.getParameter("user")); %>
<br>
EL 사용 : ${param.user}
</body>
</html>
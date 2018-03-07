<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>XSS(Cross Site Scripting)</h2>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");

//js "<" 문자를 &lt로 대체
if(name !=null){ // 자바 < > 를 일반 데이터로 돌려버림
	name = name.replaceAll("<", "&lt;");
	name = name.replaceAll(">", "&lt;");
}else{
	return;
}

%>




</p>
이름은 <%= name %>
</body>
</html>
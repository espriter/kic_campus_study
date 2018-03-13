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

if(name !=null){
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
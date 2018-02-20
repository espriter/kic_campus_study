<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> jsp_call2.jsp가 넘겨준 자료 출력</h2>
<%
// redirect 방식
//String data = request.getParameter("data");
//out.println("자료는 " + data);

//forward
String data = (String)request.getAttribute("test");
out.println("자료는(forward)" + data);

ArrayList<String> my = (ArrayList)request.getAttribute("friends");
out.println("<br>친구들은");
for(String f:my){
	out.println(f + " ");
}
%>
</body>
</html>
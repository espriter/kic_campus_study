<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Scanner"
    import="java.util.*"
    session="true"
    autoFlush="true"
    info="jsp 페이지 연습"
    errorPage="error.jsp"
%>

<%@ page
	import="java.sql.*"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

&lt; %@ 페이지 지시어는 JSP 상단에 선언(페이지의 속성, 정보 등을 선언 또는 지시하는 역할)
<br> (페이지의 속성, 정보 등의 선언 또는 지시하는 역할)
<br>
* 날짜 / 시간 출력 * <br>
<%
Calendar cal = Calendar.getInstance();
int y = cal.get(Calendar.YEAR);
out.println("현재는" + y + "년");
%>
<br>
<%= "<br>현재는 " + y + "년" %>
<br>
<%= getServletInfo() %>
<br>
<%= 10 / 2 %>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr><td colspan="2">해당 페이지로 이동</td></tr>
	<% 
	String id = (String)session.getAttribute("id");
	if(id.equals("admin")){
		
	
	%>
	<tr>
		<td><%=id %></td>
		<td><a href="http://naver.com">네이버</a></td>
		</tr>
	<%}else{ %>
	<td><%=id %></td>
	<td><a href="http://daum.net">다음</a></td>
	</tr>
	<%
	}%>
	</table>

</body>
</html>
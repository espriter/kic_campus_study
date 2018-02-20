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
String id = request.getParameter("id");
if(id.equals("")){
	response.sendRedirect("sessiontest.html");
	}

session.setAttribute("idkey", id);
session.setMaxInactiveInterval(10);
%>

* 보고 싶은 영화 선택 * <br>
<form action="session2.jsp" method="post">
<input type ="radio" name="movie" value="신과함께" selected="checked">신과 함께
<input type ="radio" name="movie" value="블랙팬서">블랙 팬서
<input type ="radio" name="movie" value="흥부">흥부
<br>
<input type="submit" value="결과보기">

<!-- 
else{
out.println("세션이 설정되지 않음")

바닥글 : 작성자 홍길동


 -->
</form>


</body>
</html>
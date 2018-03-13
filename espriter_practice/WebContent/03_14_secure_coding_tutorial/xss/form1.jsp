<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>XSS 해킹 방지 연습(시큐어 코딩에 관해)</h2>
<form action="result1.jsp" method="post">
이름 : <input type="text" name="name">
<input type="submit">
</form>
</body>
</html>
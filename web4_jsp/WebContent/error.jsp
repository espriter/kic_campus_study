<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
오류가 발생하였습니다.<br>
<%= exception.getMessage() %>
<!-- 위의 isErrorPage도 반드시 포함 -->
</body>
</html>
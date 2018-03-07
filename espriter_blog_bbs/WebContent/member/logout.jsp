<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("idKey");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<script type="text/javascript">
alert("로그아웃 성공!!");
location.href="login.jsp";
</script>
</body>
</html>
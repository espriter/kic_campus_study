<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session.removeAttribute("idKey");
session.invalidate();
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
location.href="guest_index.jsp"; // 메인으로 이동함
</script>
</body>
</html>
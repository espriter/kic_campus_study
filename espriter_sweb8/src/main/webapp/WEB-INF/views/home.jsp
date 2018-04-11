<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 요청은 resource에서 출발  -->
<P>현재 시간은 ${serverTime}. </P>

<a href="sub1">sub1</a>
<br>
<a href="sub2?irum=tom">sub2-para : tom</a>
<br>
<a href="sub2?irum=james">sub2-para : james</a>
</body>
</html>

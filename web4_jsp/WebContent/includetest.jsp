<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file = "top.jsp" %>
<%@include file = "bottom.jsp" %>
<h1>별도 작성된 파일 병합</h1>
<b>방법1 : include 지시어</b>를 사용할 수 있다.<br>
<b>방법2 : include 액션태그</b>를 사용할 수 있다.<br>
<br>
<div style="color : blue;">
<jsp:include page="intag1.jsp"></jsp:include> <!-- intag1.jsp를 포함(include) -->
</div>
<br>

<jsp:include page="intag2.jsp">
<jsp:param value="korea" name="msg"/> <!-- param에 korea라는 값을 전달 -->
</jsp:include>


</body>
</html>
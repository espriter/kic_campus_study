<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 상품 자료(@MVC - MyBatis Anno) * <p/>
<table border="1">
  <tr><th>code</th><th>sang</th><th>su</th><th>dan</th></tr>
  <c:forEach var="s" items="${data}">
  <tr>
  	<td>${s.code }</td>
  	<td>${s.sang }</td>
  	<td>${s.su }</td>
  	<td>${s.dan }</td>
  </tr>
  </c:forEach>
  <!-- 검색 -->
  <tr>
  	<td colspan="4">
  		<form action="search" method="post">
  		상품명:<input type="text" name="searchValue">
  		<input type="submit" value="검색">
  		</form>
  	</td>
  </tr>
</table>
</body>
</html>
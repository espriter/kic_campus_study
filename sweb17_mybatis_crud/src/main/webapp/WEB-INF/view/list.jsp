<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 회원 자료(@MVC-MyBatis-CRUD) *<p/>
<a href="insert">추가</a>
<br>
<table border="1">
	<tr><th>번호</th><th>이름</th><th>주소</th><th>변경</th></tr>
	<c:forEach var="m" items="${list}">
		<tr>
			<td>${m.num}</td>
			<td>${m.name}</td>
			<td>${m.addr}</td>
			<td>${m.num}</td>
			<td>
				<a href="update?num=${m.num}">수정</a>
				<a href="delete?num=${m.num}">삭제</a>
			</td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>
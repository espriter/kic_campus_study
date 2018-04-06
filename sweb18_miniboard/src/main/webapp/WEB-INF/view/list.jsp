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
* 미니 게시판(DB는 전통적인 방식) *<p/>
<a href="write">글쓰기</a>
<table border="1">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>조회수</th>
		<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.num}</td>
			<td><a href="detail.jsp?${b.num}">${b.title}</a></td>
			<td>${b.author}</td>
			<td>${b.readcnt}</td>
		</tr>
		</c:forEach>
		<!-- 검색 -->
		<tr>
			<td colspan="4">
			<form action="search" method="post">
				<select name="searchName">
				<option value="author">작성자</option>
				<option value="title">제목</option>
				</select>
				<input type="text" name="searchValue">
				<input type="submit" value="검색하기">
			</form>
	</tr>
</table>
</body>
</html>
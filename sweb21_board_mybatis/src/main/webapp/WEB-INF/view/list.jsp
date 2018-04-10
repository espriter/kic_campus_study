<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" type="text/css" href="resources/css/board.css">
</head>
<body>
<h2 align="left">** 게시판(@MVC - MyBatis) **</h2>
<table>
	<Tr align="left">
			<Td>
			[<a href="list?page=1">최근목록</a>]
			[<a href="write">새글 작성</a>]
			</Td>
	</Tr>
	<tr>
		<td>
			<table border="1">
				<Tr>
					<th>번호</th><th>글제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
				</Tr>
				<c:forEach var="b" items="${data }">
				<!-- 댓글 들여쓰기 -->
				<c:set var="tab" value=""/>
				<c:forEach var="n" begin="1" end="${b.nested}">
					<c:set var="tab" value="${tab}&nbsp;&nbsp;"/>				
				</c:forEach>				
					<Tr>
						<Td>${b.num }</Td>
						<td>
							${tab}
							<a href="detail?num=${b.num}&page=${page}" >${b.title }</a>
						</td>
						<Td>${b.name }</Td>
						<Td>${b.bdate }</Td>
						<td>${b.readcnt }</td>
					</Tr>
				</c:forEach>
				<!--  paging -->
				<Tr style="text-align: center;">
					<Td colspan="5">
						<c:forEach var="i" begin="1" end="${pagesu }">
							<c:if test="${i == page}">
								<b>${i }</b>
							</c:if>
							<c:if test="${i != page }">
								<a href="list?page=${i }">${i }</a>
							</c:if>
						</c:forEach>
					</Td>
				</Tr>
				<!--  검색 -->
				<Tr style="text-align: center;">
					<td colspan="5">
							<form action="search" method="post">
								<select name="searchName">
									<option value="name">작성자</option>
									<option value="title">글 제목</option>
								</select> <input type="text" name="searchValue"> <input
									type="submit" value="검색">
							</form>
						</td>
				</Tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>














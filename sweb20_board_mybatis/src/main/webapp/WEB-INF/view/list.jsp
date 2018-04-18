<%@page import="pack.model.BoardDaoInter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%
int pageSu, spage = 1;

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>
		[<a href="signup.jsp">회원가입</a>]&nbsp;
		[<a href="index">메인으로</a>]&nbsp;
		[<a href="list?page=1">최근목록</a>]&nbsp;
		[<a href="boardwrite.jsp">새글작성</a>]&nbsp;
		
		<br><br>
		<table style="width: 100%">
					<tr style="background-color: silver;">
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:forEach var="b" items="${data}">
						<tr>
							<td>${b.num }</td>
							<td><a href="detail?num=${b.num}">${b.title}</a></td>
							<td>${b.name }</td>
							<td>${b.bdate}</td>
							<td>${b.readcnt}</td>
						</tr>
					</c:forEach>
				</table> <br>
				<table style="width: 100%">
					<tr>
						<td style="text-align: center;">

						<br>
						<br>
							<form action="list" name="frm" method="post">
								<select name="stype">
									<option value="title" selected="selected">글제목</option>
									<option value="name">작성자</option>
								</select> <input type="text" name="sword"> <input type="button"
									value="검색" id="btnSearch">
							</form>
						</td>
					</tr>
				</table>
			</td>
	</tr>
</table>
</body>
</html>
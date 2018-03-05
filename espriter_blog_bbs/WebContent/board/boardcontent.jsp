<%@page import="pack.board.BoardMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>

<%
String num = request.getParameter("num");
String spage = request.getParameter("page"); // spage는 몇페이지인지 확인하는 것 : 1페이지/ 2페이지 ...
//out.println(num + " " + spage);

dto = boardMgr.getData(num); // 해당 자료 불러오기 from BoardMgr.java


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<table>
	<tr>
		<td>비밀번호 :<%=dto.getPass()%></td>
		<td></td>
	</tr>
	<tr>
		<td>
		작성자 : <%=dto.getName() %>(mail:<%=dto.getMail() %>)
		ip : <%=dto.getBip() %>
		작성일 : <%= dto.getBdate() %>
		조회수 : <%= dto.getReadcnt() %>
		</td>
		</tr>
		<tr>
		<td colpan="3">
		제목 : <%= dto.getTitle() %>
		</td>
		</tr>
		<br>
		<tr>
		<td colpan="3">
		<textarea rows="10" style="width: 100%" readonly="readonly">내용 : <%= dto.getCont() %></textarea>
		</td>
		</tr>
</table>
</body>
</html>
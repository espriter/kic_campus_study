<%@page import="pack.board.BoardMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>

<%
String num = request.getParameter("num");
String spage = request.getParameter("page"); // spage는 몇페이지인지 확인하는 것 : 1페이지/ 2페이지 ...
//out.println(num + " " + spage);

boardMgr.updateReadcnt(num);// 조회수 증가
dto = boardMgr.getData(num); // 해당 자료 불러오기 from BoardMgr.java

String pass = dto.getPass();
String mypass = "*****"; //일반인은 비밀번호가 보이지 않도록
String adminOk = (String)session.getAttribute("adminOk");
if(adminOk != null){
	if(adminOk.equals("admin")) mypass = pass; // 관리자는 비밀번호를 볼 수 있도록
}

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
		<td>비밀번호 :<%=mypass%></td>
		<td style="text-align:right">
		<a href="reply.jsp?num=<%=num%>&page=<%=spage%>">
		<img src="../images/reply.gif">
		</a>
		<a href="edit.jsp?num=<%=num %>&page=<%=spage%>">
		<img src="../images/edit.gif">
		</a>
		<a href="delete.jsp?num=<%=num %>&page=<%=spage%>">
		<img src="../images/del.gif">
		</a>
		<a href="boardlist.jsp?num= <%=spage%>">
		<img src="../images/list.gif">
		</a>
		</td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="BoardMgr" class="pack.board.BoardMgr"/>
    <jsp:useBean id="dto" class="pack.board.BoardDto"/>
    
   <%
   
   String num = request.getParameter("num");
   String spage = request.getParameter("page");
   dto = BoardMgr.getReplyData(num);
   
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply</title>
</head>
<body>

</body>
</html>
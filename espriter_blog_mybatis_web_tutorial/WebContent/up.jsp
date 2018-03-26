<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    <%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    DataDto dto = processDao.selectDataPart(id);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 회원 수정 **</title>
</head>
<body>
<h2>** 회원 수정 **</h2>
<form action="up_ok.jsp" method="post">
i d : <input type ="hidden" name="id" value="<%=dto.getId() %>">
<%=dto.getId() %><br>
name: <input type="text" name="name" value="<%=dto.getName() %>"><br>
p w : <input type="text" name="passwd"><br>
<br>
<input type="submit" value="등록">
</form>
</body>
</html>
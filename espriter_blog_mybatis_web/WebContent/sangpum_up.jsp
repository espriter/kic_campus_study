<%@page import="pack.business.DataDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
    <%
    String code = request.getParameter("code");
    DataDto dto = processDao.selectDataById(code);    
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 수정</h2>
<form action ="sangpum_upok.jsp" method="post">
<input type="hidden" name="code" value="<%=dto.getCode()%>"><br>
코드 : <%=dto.getCode()%><br>
품명 : <input type="text" name="sang" value="<%=dto.getSang()%>"><br>
수량 : <input type="text" name="su" value="<%=dto.getSu()%>"><br>
단가 : <input type="text" name="dan" value="<%=dto.getDan()%>"><br>
<br>
<input type="submit" value="수정">
</form>
</body>
</html>
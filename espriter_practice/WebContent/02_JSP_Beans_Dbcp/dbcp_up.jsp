<%@page import="pack.SangpumDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="process" class="pack.DbcpProcess" />
<% 
String code = request.getParameter("code"); 
SangpumDto dto = process.updateData(code); 
if(dto == null){
%>
<script>
	location.href="beandb_dbcp.jsp";
	alert("등록된 상품코드가 아닙니다.\n수정 불가!");
</script>
<%	
	return;
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 상품 수정 **<p/>
<form action="dbcp_upok.jsp" method="post">
코드 : <%=dto.getCode() %><br>
<input type="hidden" name="code" value="<%=dto.getCode()%>">
품명 : <input type="text" name="sang" value="<%=dto.getSang()%>"><br>
수량 : <input type="text" name="su" value="<%=dto.getSu()%>"><br>
단가 : <input type="text" name="dan" value="<%=dto.getDan()%>"><br>
<br>
<input type="submit" value="자료수정">
<input type="button" value="목록보기" 
	onclick="javascript:location.href='beandb_dbcp.jsp'">
</form>
</body>
</html>







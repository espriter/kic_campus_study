<%@page import="pack3.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="process" class="pack3.DbProcess" scope="page"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean을 활용한 자료 입력</title>
</head>
<body>
<h2>상품 자료(Beans)</h2>
<table border="1">
	<tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th>
	<%
	ArrayList<SangpumDto> list = process.getDataAll();
	for(int i = 0; i < list.size(); i++){
		SangpumDto dto = (SangpumDto)list.get(i);
	%>
	<tr>
		<td><%=dto.getCode() %></td>
		<td><%=dto.getSang() %></td>
		<td><%=dto.getSu() %></td>
		<td><%=dto.getDan() %></td>
		
		</tr>
	<%
	}
	%>
</table>
<br>
향상된 for 사용하여 출력<br>
<table border ="1">
<tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th>
<%
for(SangpumDto s:list) {
%>
	<tr>
	<td><%=s.getCode() %></td>
	<td><%=s.getSang() %></td>
	<td><%=s.getSu() %></td>
	<td><%=s.getDan() %></td>
	</tr>
<%	
}
%>
</table>

</body>
</html>
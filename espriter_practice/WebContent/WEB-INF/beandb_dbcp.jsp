<%@page import="pack.SangpumDto"%> 
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="process" class="pack.DbcpProcess" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function funcUpdate(){
	alert("aa");
}

function funcDelete(){
	alert("bb");
}
</script>
</head>
<body>
<h2>상품 자료(Beans + Dbcp)</h2>
<a href="dbcp_ins.html">추가</a>&nbsp;
<a href="javascript:funcUpdate()">수정</a>&nbsp;
<a href="javascript:funcDelete()">삭제</a>
<br>
<table border="1">
  <tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th></tr>
<%
ArrayList<SangpumDto> list = process.getDataAll();

for(SangpumDto s:list){
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
<tr>
	<td colspan="4">건수 : <%=list.size() %></td>
</tr> 
</table>
</body>
</html>







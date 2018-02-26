<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
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
	//alert("aa");
	var code = prompt("수정할 코드 입력","");
	//alert(code);
	if(code != "" && code != null){
		location.href="dbcp_up.jsp?code=" + code;
	}
}

function funcDelete(){
	//alert("bb");
	var code = prompt("삭제 할 코드 입력","");
	if(code != "" && code != null){
		if(confirm("정말 삭제할겁니까??") == true){
		location.href="dbcp_del.jsp?code=" + code;
	}
	
}
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







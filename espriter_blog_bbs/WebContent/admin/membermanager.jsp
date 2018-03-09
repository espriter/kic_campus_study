<%@page import="pack.member.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원관리</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<h2> ** 관리자-전체회원 관리 **</h2>
<%@ include file="../admin/admin_top.jsp" %>
<table style="width:90%; text-align:center;">
	<tr style="background-color:cyan;">
		<th>아이디</th><th>회원명</th><th>이메일</th><th>전화</th><th>수정</th>	
	</tr>
	<%
	ArrayList<MemberBean> list = memberMgr.getMemberAll();
	for(MemberBean m:list){
	%>
	<tr style="text-align:center;">
		<td><%=m.getId() %></td>
		<td><%=m.getname() %></td>
		<td style="text-align:left;"><%=m.getEmail() %></td>
		<td><%=m.getPhone() %></td>
		<td><a href="javascript:memUpdate('<%= m.getId() %>')">수정</a></td>
	<%	
	}
	%>	
</table>
<%@ include file="../admin/admin_bottom.jsp" %> 

<form action="memberUpdate_admin.jsp" name="updateFrm" method="post">
<input type="hidden" name="id">

</form>

</body>
</html>
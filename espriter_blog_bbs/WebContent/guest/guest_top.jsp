<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String memid = (String)session.getAttribute("idKey"); //loginproc.jsp의 값(idKey)이 일치해야 됨

String log = "";
if(memid == null){
	log = "<a href='login.jsp'>로그인</a>"; 
}else{
	log = "<a href='logout.jsp'>로그아웃</a>";
}

String mem ="";
if(memid == null){
	mem = "<a href='../member/register.jsp'>회원가입</a>"; 
}else{
	mem = "<a href='../member/memberupdate.jsp'>회원정보 수정</a>";
}

%>
<table style="width: 90%">
	<tr style="background-color:#F7BE81; text-align:center;">
		<td><%=log %></td>
		<td><%=mem %></td>
		<td><a href="productlist.jsp">상품목록</a></td>
		<td><a href="cartlist.jsp">장바구니</a></td>
		<td><a href="orderlist.jsp">구매목록</a></td>
		<td><a href="../board/boardlist.jsp">게시판(Q&A)</a></td>
	</tr>

</table>
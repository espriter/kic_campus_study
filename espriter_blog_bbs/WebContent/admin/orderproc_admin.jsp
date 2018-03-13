<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr" />

<%
String no = request.getParameter("no");
String state = request.getParameter("state");
String flag = request.getParameter("flag");

boolean b = false;
if(flag.equals("update")){ 
	b = orderMgr.updateOrder(no, state);
}else if(flag.equals("delete")){
	//b = orderMgr.deleteOrder(no);
}else{
	response.sendRedirect("ordermanager.jsp");
}

if(b){
%>
	<script>
	alert("정상적으로 처리되었습니다");
	location.href = "ordermanager.jsp";
	</script>
<%}else{%>
	<script>
	alert("작업 실패!\n프로그램 관리자에게 문의바람");
	location.href = "ordermanager.jsp";
	</script>
<%	
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="processDao" class="pack.business.ProcessDao"/>
<%
String code = request.getParameter("code");
boolean b = processDao.delData(Integer.parseInt(code));

if(b){
	response.sendRedirect("sangpum_list.jsp");
}else{
%>
	<script>
		alert("삭제 실패!");
		location.href="sangpum_pist.jsp";	
	</script>
<%
}
%>
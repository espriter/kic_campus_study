<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="process" class="pack.DbcpProcess" />
<% 
String code =  request.getParameter("code"); 

if(process.deleteData(code)){
	response.sendRedirect("beandb_dbcp.jsp");
}else{
	response.sendRedirect("beandb_fail.html"); 
}
%>
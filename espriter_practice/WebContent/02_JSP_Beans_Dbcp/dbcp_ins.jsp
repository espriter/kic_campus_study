<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="bean" class="pack.SangpumBean" />
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="process" class="pack.DbcpProcess" />
<%
//System.out.println(bean.getSang());
//System.out.println(bean.getSu());
//System.out.println(bean.getDan());

boolean b = process.insertData(bean); 
if(b){
	response.sendRedirect("beandb_dbcp.jsp");  //추가 후 목록 보기
}else{
	response.sendRedirect("beandb_fail.html"); // 추가 실패 시
}
%>

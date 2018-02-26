<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %> // 한글 처리
<jsp:useBean id="bean" class="pack.SangpumBean"/>
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="process" class="pack.DbcpProcess"/>
<%
if(process.updateDataOk(bean)) {
	response.sendRedirect("beandb_dbcp.jsp"); // 수정 성공 후 목록보기
}else{
	response.sendRedirect("beandb_fail.html"); // 수정 실패 시
	
}
%>


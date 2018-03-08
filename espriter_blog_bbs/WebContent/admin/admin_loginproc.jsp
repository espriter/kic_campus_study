<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
String adminid = request.getParameter("adminid");
String adminpasswd = request.getParameter("adminpasswd");

boolean b = memberMgr.adminLoginCheck(adminid, adminpasswd);

if(b){
	session.setAttribute("adminKey", "adminId"); // 관리자 로그인 세션 유지
	response.sendRedirect("admin_index.jsp");
}else{
%>
	<script>
	alert("로그인 실패! 돌아가!");
	</script>
	<% response.sendRedirect("adminlogin.jsp"); %>
<%
}
%>
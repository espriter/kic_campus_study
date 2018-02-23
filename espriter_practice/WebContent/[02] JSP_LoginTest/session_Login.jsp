<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 내부적으로 처리 -->
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

if((id.equals("admin") && pwd.equals("123")) ||
	(id.equals("user") && pwd.equals("111"))){
	session.setAttribute("id",id);
	response.sendRedirect("loginok.jsp");
	}else{
		//response.sendRedirect("loginfail.jsp");
	}
%>

<script>
alert("로그인 실패");
location.href="loginfail.jsp";
</script>
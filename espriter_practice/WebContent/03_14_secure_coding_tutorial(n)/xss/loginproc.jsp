<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="pack.MemberDao" scope="page"></jsp:useBean>
<%
request.setCharacterEncoding("utf-8");
String no = request.getParameter("no");
String name = request.getParameter("name");

// 인증처리
boolean chk = dao.loginChk(no, name);
if(chk){ //인증 성공할 때
	session.setAttribute("namekey",name);
	response.sendRedirect("logsuccess.jsp");
}else { //인증 실패할 때
	response.sendRedirect("logerr.jsp");
}


%>
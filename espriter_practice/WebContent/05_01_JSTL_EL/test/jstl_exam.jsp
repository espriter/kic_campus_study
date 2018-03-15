<%@page import="pack.jstl.GogekDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pdb" class="pack.jstl.PoolingDb"></jsp:useBean>
<%
ArrayList<GogekDto> gogekList = pdb.getGogekdata();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2018-03-13 연습문제</title>
</head>
<body>
<table border="1">
	<tr>
		<th>고객번호</th><th>고객명</th><th>고객전화</th><th>성별</th>
	</tr>

<c:forEach var="i" items="<%=gogekList %>">
	<tr>
		<td>${i.gogek_no }</td><td><a href="jstl_exam_jik.jsp?jik=${i.gogek_damsano}" target="ifrm">${i.gogek_name }</a></td><td>${i.gogek_tel }</td>
		<c:choose>
			<c:when test="${fn:substring(i.gogek_jumin,7,8) == '1' }"><td>남</td></c:when>
			<c:when test="${fn:substring(i.gogek_jumin,7,8) == '2' }"><td>여</td></c:when>
		</c:choose>
	</tr>
</c:forEach>
</table>

<iframe name="ifrm" width="90%" height="300px" frameborder="0"></iframe>
</body>
</html>
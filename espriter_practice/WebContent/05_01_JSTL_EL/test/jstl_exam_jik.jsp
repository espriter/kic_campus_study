<%@page import="pack.jstl.SawonDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pdb" class="pack.jstl.PoolingDb"></jsp:useBean>
<%
String no = request.getParameter("jik");
SawonDto dto = pdb.getSawondata(no);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>담당직원</h2>
이름 : <%=dto.getSawon_name() %> &nbsp;
부서명 : 
<c:set var="buNum" value="<%=dto.getbuser_num() %>" />
<c:choose >
	<c:when test="${buNum== '10'}">총무부</c:when>
	<c:when test="${buNum == '20'}">영업부</c:when>
	<c:when test="${buNum == '30'}">전산부</c:when>
	<c:when test="${buNum == '40'}">관리부</c:when>
</c:choose>
<br>
부서전화:
<c:choose>
	<c:when test="${buNum == '10'}">02-100-1111</c:when>
	<c:when test="${buNum == '20'}">02-100-2222</c:when>
	<c:when test="${buNum == '30'}">02-100-3333</c:when>
	<c:when test="${buNum == '40'}">032-200-4444</c:when>
</c:choose>

직급:<%=dto.getSawon_jik() %>



</body>
</html>
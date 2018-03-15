<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 문자열 분할 JSTL TEST **</title>
</head>
<body>
<h2>** 문자열 분할 JSTL TEST ** </h2>
<c:forTokens var="ani" items="horse,tiger,lion" delims=",">
동물: <c:out value="${ani}"/><br>
</c:forTokens>

<p/>
--- 숫자 및 날짜 서식 ---
<%@ taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><br>
숫자 : <fmt:formatNumber value="98745612345.678" type="number"/><br>
통화 : <fmt:formatNumber value="12345.789" type="currency" currencySymbol="$"/><br>
숫자 : <fmt:formatNumber value="12345.456" pattern="#,##0.0"/><br>
<c:set var="kor" value="77" />
<c:set var="eng" value="88" />
<c:set var="mat" value="91" />
다 합해서 나누기 3 : <fmt:formatNumber value="${(kor + eng + mat) / 3}" pattern="##0.0"/>
<br>
<hr>
<c:set var="now" value="<%=new Date() %>" />
${now}
<br>
날짜 : <fmt:formatDate value="${now}" type="date"/><br>
시간 : <fmt:formatDate value="${now}" type="time"/><br>
날짜 : <fmt:formatDate value="${now}" type="both" dateStyle="full"/>


</body>
</html>
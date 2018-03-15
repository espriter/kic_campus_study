<%@page import="pack.jstl.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Man 결과 출력:<br>
전통 : Hi <%= request.getAttribute("man") %><br>
EL : Hi ${requestScope.man} ${man}<p>
<hr>
Person EL : Hi ${requestScope.person} ${person.age}<p>
<hr>
EL : ${animals[0]} ${animals[1]} ${animals["2"]}

EL : ${animals[0]} ${animals[1]} ${animals["2"]}<p>

<c:if test="${list !=null}">
	<c:forEach var="a" items="${list}">
		<c:forEach var="b" items="${a}">
			${b}&nbsp;
	</c:forEach>
			<br>
		</c:forEach>
</c:if>
<br>
<c:choose>
	<c:when test="${list eq null}">자료 없음</c:when>
	<c:otherwise>자료 있네요</c:otherwise>
</c:choose>
<hr>
예외처리 : <br>
<c:catch var="myErr">
<%int a = 10 / 0; out.println(a); %>
</c:catch>
<c:if test="%{myErr != null">
 에러 발생 : ${myErr.message} <br>
 </c:if>
 <br>
 다른 문서 포함<br>
 incldue 지시어 : <%@include file="jstl6_poham.jsp" %>
 <br>
 jsp action tag : <jsp:include page="jstl6_poham.jsp"/>
 <br>
 jstl: <c:import url="jstl6_poham.jsp"/>
 <br>
 <c:import url="https://www.daum.net"/>
 <br>
 <c:set var="url" value="https://daum.net"/>
 <c:import url="${url}" var="u"/>
 <c:out value="${url}"/><br><Br>
 <c:out value="${u}"/>
</body>
</html>
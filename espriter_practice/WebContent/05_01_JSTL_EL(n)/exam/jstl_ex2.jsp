<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>* JSTL TEST2 *</title>
</head>
<body>
<h2> * JSTL TEST2 *</h2>
-- 제어문 : 조건 판단 --
<c:set var="kbs" value="moon"/>
<c:if test="${kbs == 'star'}">
if 연습 : kbs 값은 <c:out value="${kbs}"/> <!-- KBS가 STAR라는 조건에 부합할 경우에 출력 -->
</c:if>
<br>
<c:if test="${kbs eq 'moon'}">
if 연습 : 아하 달이네  <!-- 13번 줄의 value 값에 달라서 출력 유무 결정 -->
</c:if>

<p>
choose 문 사용(if ~else는 choose로 표현)<br>
<c:choose>
	<c:when test="${kbs =='star'}">별</c:when>
	<c:when test="${kbs =='moon'}">달</c:when>
	<c:otherwise>어떤 조건도 아닐 경우 수행</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${empty param.name}">
	<form>
	이름 : <input type="text" name="name">
		<input type="submit" value="확인">
	</form>
	</c:when>
	<c:when test="${param.name == 'admin' }">
		관리자 작업
	</c:when>
	<c:when test="${param.name eq 'user' }">
		일반 사용자. 회원 <c:out value="${param.name}" />
	</c:when>
		<c:otherwise>
			기타 작업
		</c:otherwise>
</c:choose>

</p>
</body>
</html>
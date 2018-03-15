<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>* JSTL TEST *</title>
</head>
<body>
<h2>* JSTL TEST *</h2>
--- 변수 선언 ---<br>
<c:set var="ir" value="홍길동" scope="page"/> <!--  자바 객체는 value에 다 들어올 수 있음 / request,page,session,application -->
<c:out value="${ir}"/><br>
\${ir} ==> ${ir}
<br><hr>
<c:set var="ir2" scope="session">
한국인
</c:set>
<c:out value="${ir2}"/>
<br><hr>
<c:set var="aa" value="${header['User-Agent']}" scope="page"/>
USER-AGENT 값은 : <c:out value="${aa}"/>
<br>
<c:remove var="aa" scope="page"/> <!-- remove는 삭제한다는 의미 -->
aa 삭제 후 값은 >>[ <c:out value="${aa}"/> ] >> 변수값이 삭제됨
<br>
<c:set var="su1" value="10"/>
<c:set var="su2" value="${20}"/>
<c:set var="su3">
30.5
</c:set>
합은 ${su1 + su2 + su3}<br>
</body>
</html>
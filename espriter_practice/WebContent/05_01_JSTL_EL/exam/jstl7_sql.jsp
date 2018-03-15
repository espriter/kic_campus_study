<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSTL로 db 자료 읽기(상품)<p/>
<c:catch var="err">
<sql:setDataSource
var = "ds"
url="jdbc:mysql://localhost:3306/test"
driver="org.mariadb.jdbc.Driver"
user="root"
password="123"
/>
<sql:query var="rs" dataSource="${ds}">
select * from sangdata where code >= ? and code <= ?
<sql:param value="${1}"/>
<sql:param value="5" />
</sql:query>

<table border="1">
	<tr>
	<th>code</th><th>sang</th><th>su</th><th>dan</th>
	<c:forEach var="s" items="${rs.rows}">
	<tr>
		<td>${s.code}</td>
		<td>${s.sang}</td>
		<td>${s.su}</td>
		<td>${s.dan}</td>
	</tr>
	</c:forEach>
	</tr>

</table>


</c:catch>
<c:if test="%{err !=null}">
	에러 : ${err.message}
</c:if>
</body>
</html>
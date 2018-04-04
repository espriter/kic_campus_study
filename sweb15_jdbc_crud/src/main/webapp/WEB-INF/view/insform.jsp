<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** 자료 추가 **</h2>
<sform:form commandName="command">
아이디 : <sform:input path="id"/><br>
비밀번호 : <sform:input path="passwd"/><br>
회원명 : <sform:input path="name"/><br>
<input type="submit" value="추가">
</sform:form>

</body>
</html>
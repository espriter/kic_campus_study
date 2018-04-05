<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 자료 수정 * <p/>
<form action ="update" method="post">
<input type="hidden" name="id" value="${updata.id}">
아이디 : ${updata.id} <br>
회원명 : <input type="text" name="name" value="${updata.name}"><br>
비밀번호 : <input type="text" name="passwd" value="${updata.passwd}"><br>
<br>
<input type="submit" value="수정확인">
</form>
</body>
</html>
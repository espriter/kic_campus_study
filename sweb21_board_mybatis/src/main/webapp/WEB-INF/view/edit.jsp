<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 글 수정 ***<p/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${msg !=null}">
<script type="text/javascript">
(function msg(){
	alert("${msg}")
})();
</script>
</c:if>
<form action="edit" method="post">
<input type="hidden" name="num" value="${data.num}">
<input type="hidden" name="page" value="${page}">
<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="name" value="${data.name}"></td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="text" name="pass"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="mail" value="${data.mail}"></td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td><input type="text" name="title" value="${data.title}"></td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td><textarea rows="5" cols="50" name="cont">${data.cont}</textarea></td>
	</tr>
	<tr>
		<td colspan="5" style="text-align:center;">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick = "location.href='list?page=${page}'">
		</td>
	</tr>
</table>
</form>
</body>
</html>
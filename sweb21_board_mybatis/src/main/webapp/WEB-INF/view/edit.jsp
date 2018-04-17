<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
*** 글 수 정 ***<p/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${msg != null }">
<script>
(function msg(){
	alert("${msg}");
})();
</script>
</c:if>

<form action="edit" method="post">
<input type="hidden" name="num" value="${data.num }">
<input type="hidden"  name="page" value="${page }">
	<table border="1" >
		<tr>
			<td>작성자</td>
			<td><input type="text" name="name" value="${data.name }"></td>
		</tr>
		<Tr>
			<td>암  호</td>
			<td><input type="text" name="pass" ></td>
		</Tr>
		<Tr>
			<td>이메일</td>
			<td><input type="Text" name="mail"  value="${data.mail }"></td>
		</Tr>
		<tr>
			<td>글제목</td>
			<td><input type="Text" name="title" value="${data.title }"></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td>
				<textarea rows="5" cols="20" name="cont">${data.cont }</textarea>
			</td>
		</tr>
		<tr>
			<Td colspan="5" style="text-align: center;">
				<input type="submit" value="수  정" >
				<input type="button" value="목  록" onclick="location.href='list?page=${page}'">
			</Td>
		</tr>
	</table>
</form>
</body>
</html>
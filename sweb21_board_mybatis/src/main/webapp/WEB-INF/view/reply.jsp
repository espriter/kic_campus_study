<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 댓글 쓰기 ** <p/>
<form action="reply" method="post">
<input type="hidden" name="num" value="${data.num }">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="gnum" value="${data.gnum }">
<input type="hidden" name="onum" value="${data.onum }">
<input type="hidden" name="nested" value="${data.nested }">
<input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>">
<table border="1" style="width: 80%">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="name"></td>
		</tr>
		<Tr>
			<td>암  호</td>
			<td><input type="text" name="pass"></td>
		</Tr>
		<Tr>
			<td>이메일</td>
			<td><input type="Text" name="mail"></td>
		</Tr>
		<tr>
			<td>글제목</td>
			<td><input type="Text" name="title"></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><textarea rows="5" cols="20" name="cont"></textarea>
		</tr>
		<tr>
			<Td colspan="5" style="text-align: center;">
				<input type="submit" value="작  성" >
				<input type="button" value="목  록" onclick="location.href='list?page=${page}'">
			</Td>
		</tr>
	</table>
</form>
</body>
</html>
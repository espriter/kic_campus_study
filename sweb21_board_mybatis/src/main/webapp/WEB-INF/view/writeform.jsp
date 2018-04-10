<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 글 쓰기 ***<p/>
<form action="write" method="post">
<table border="1">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="text" name="pass"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="mail"></td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td><textarea rows="5" cols="50" name="cont"></textarea></td>
	</tr>
	<tr>
		<td colspan="5" style="text-align:center;">
			<input type="hidden" name="bip" value="<%=request.getRemoteAddr()%>">
			<input type="submit" value="입력하기">
			<input type="button" value="목록" onclick = "location.href='list?page=1'">
		</td>
	</tr>
</table>
</form>
</body>
</html>
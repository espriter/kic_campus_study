<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
*** 회원 가입 ***<p/>
<form action="write" method="post">
	<table border="1" style="width: 80%">
		<tr>
			<td>이름</td>
			<td><input type="text" name="user_name"></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="user_id"></td>
		</tr>
		<tr>
			<td>암  호</td>
			<td><input type="text" name="user_password"></td>
		</tr>
		<tr>
			<td colspan="5" style="text-align: center;">
				<input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>">
				<input type="submit" value="전  송" >
			</td>
		</tr>
	</table>
</form>
</body>
</html>
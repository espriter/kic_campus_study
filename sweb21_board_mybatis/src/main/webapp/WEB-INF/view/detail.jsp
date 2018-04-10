<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<td>비밀번호 : ${data.pass}</td>
		<td>
			<a href="reply?num=${data.num}&page=${page}">
				<img src="resources/images/reply.gif">
			</a>
		</td>
		<td>
			<a href="edit?num=${data.num}&page=${page}">
				<img src="resources/images/edit.gif">
			</a>
		</td>
		<td>
			<a href="delete?num=${data.num}&page=${page}">
				<img src="resources/images/del.gif">
			</a>
		</td>
		<td>
			<a href="list?page=${page}">
				<img src="resources/images/list.gif">
			</a>
		</td>
	</tr>
	</table>
<table>
	<tr>
		<td>작성자 : ${data.name} → ${data.mail} (ip : ${data.bip})</td>
	</tr>
	<tr>
		<td>작성일 : ${data.bdate}</td>
		<td>조회수 : ${data.readcnt}</td>
	</tr>
	<tr>
		<td>제목 : ${data.title}</td>
	</tr>
	<tr>
		<td>
			<textarea rows="5" cols="30" readonly="readonly">${data.cont}</textarea>
		</td>
	</tr>
</table>	
</body>
</html>

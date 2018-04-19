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
			<td>비밀번호 : ${data.pass }</td>
			<Td style="text-align: right;">
				<a href="reply?num=${data.num }&page=${page}">
				 	<img src="resources/images/reply.gif">
				</a> 
				<a href="edit?num=${data.num }&page=${page}"> 
					<img src="resources/images/edit.gif">
				</a> 
				<a href="delete?num=${data.num }&page=${page}"> 
					<img src="resources/images/del.gif">
				</a>
				 <a href="list?page=${page }"> 
				 	<img src="resources/images/list.gif">
				</a>
			</Td>
		</tr>
	</table>
	<table>
		<tr>
			<td>작성자 : ${data.name } → ${data.mail } (ip : ${data.bip })</td>
		</tr>
		<Tr>
			<td>작성일 : ${data.bdate }</td>
		</tr>
		<tr>	
			<Td>조회수 : ${data.readcnt }</Td>
		</tr>
		<tr>
			<Td>제 목 : ${data.title }</Td>
		</tr>
		<Tr>
			<td><textarea rows="5" cols="30" readonly="readonly">${data.cont }</textarea>
			</td>
		</Tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 상세보기 * <p/>
<table>
	<tr><td>아이디</td><td>${mem.id}</td></tr>
	<tr><td>비밀번호</td><td>${mem.passwd}</td></tr>
	<tr><td>회원명</td><td>${mem.name}</td></tr>
	<tr><td>등록일</td><td>${mem.regdate}</td></tr>
	<tr>
		<td colspan="2">
			<a href="list">목록</a>
			<a href="update?id=${mem.id}">수정</a>&nbsp;
			<a href="delete?id=${mem.id}">삭제</a>
	</tr>
</table>
</body>
</html>
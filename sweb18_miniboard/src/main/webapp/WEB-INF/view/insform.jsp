<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 글쓰기 ** <p/>
<form action="write" method="post">
글제목 : <input type="text" name="title"><br>
작성자 : <input type="text" name="author"><br>
글내용 : <textarea rows="5" cols="30" name="content"></textarea>
<br><br>
<input type="submit" value="저장">
</form>
</body>
</html>
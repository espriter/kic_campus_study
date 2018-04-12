<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
* 이메일 보내기 *
<form action="send" method="post">
이메일 : <input type="email" name="receiver" placeholder="abc@abc.com"><br>
글제목 : <input type="text" name="subject"><br>
글 내용 : <textarea rows="5" cols="30" name="content"></textarea>
<p>
<input type="submit" value="메일 보내기">
</form>
</body>
</html>
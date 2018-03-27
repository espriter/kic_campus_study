<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnInsert").onclick=function(){
		
		//입력자료 오류검사 생략
		f.command.value="insert";
		f.action="insert.m2";
		f.submit();
		
	}
	document.getElementById("btnList").onclick=function(){
		f.command.value="list";		//주지 않아도 됨.
		f.action = "list.m2";
		f.submit();
	}
}
</script>
</head>
<body>
** 사용자 추가 ** <p/>
<form name="f" method="post">
	<input type="hidden" name="command" value="insert">
	아 이 디 : <input type="text" name="userid"/><br>
	비밀번호 : <input type="text" name="password"/><br>
	작 성 자 : <input type="text" name="name"/><br>
	이 메 일 : <input type="text" name="email"/><br>
	<input type="button" value="추가" id="btnInsert">
	<input type="button" value="목록" id="btnList">
	
</form>
</body>
</html>
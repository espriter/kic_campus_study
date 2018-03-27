<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC TEST</title>
<script type="text/javascript">
window.onload = function(){
	var btnLogin = document.getElementById("btnLogin");
	btnLogin.addEventListener("click", loginFunc, false);
	
	document.getElementById("btnInsert").addEventListener("click", insertFunc, false);
}

function loginFunc(){
	if(f.userid.value == ""){
		alert("아이디를 입력하세요");
		f.userid.focus();
		return false;
	}
	if(f.password.value == ""){ 
		alert("비밀번호를 입력하세요");
		f.password.focus();
		return false;
	}
	
	f.command.value = "login";
	f.action= "login.m2";
	f.submit();
}

function insertFunc(){
	f.action = "userinsert.jsp";
	f.submit();
}
</script>
</head>
<body topmargin="20">
	<form name="f" method="post">
		** 사용자 관리(MVC)-로그인 **<br> <input type="hidden" name="command" />
		아 이 디 : <input type="text" name="userid" /><br> 비밀번호: <input
			type="text" name="password" /><br> <input type="button"
			value=" 로 그 인 " id="btnLogin" /> <input type="button" value="회원가입"
			id="btnInsert" />
	</form>
</body>
</html>
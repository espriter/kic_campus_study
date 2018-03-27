<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnUpdateOk").onclick=function(){
		
		//입력자료 오류검사 생략
		f.command.value ="update";
		f.action="update.m2";
		f.submit();
		
	}
	document.getElementById("btnListOk").onclick=function(){
		f.command.value = "list";		//주지 않아도 됨.
		f.action = "list.m2";
		f.submit();
	}
}
</script>
</head>
<body>
** 사용자 수정 ** <p/>
<form name="f" method="post">
	<input type="hidden" name="command">
	<input type="hidden" name="userid" value="${user.userid}">
 	아 이 디 : ${user.userid}<br>
	비밀번호 : <input type="text" name="password" value="${user.password}"/><br>
	작 성 자 : <input type="text" name="name" value="${user.name}"/><br>
	이 메 일 : <input type="text" name="email" value="${user.email}"/><br>
	<input type="button" value="수정" id="btnUpdateOk">
	<input type="button" value="목록" id="btnListOk">
</form>
</body>
</html>






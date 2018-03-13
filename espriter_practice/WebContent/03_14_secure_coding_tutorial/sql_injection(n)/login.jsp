<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function loginChk(){
	if(document.login.no.value == ""){
		alert("사번 입력");
		return;
		
	}
	
	if(document.login.name.value == ""){
		alert("이름 입력");
		return;
		
	}
	document.login.submit();
}

</script>


</head>
<body>	
<form action="loginproc.jsp" name="login">
* 로그인 *<br>
사번 : <input type="text" name="no"><br>
이름 : <input type="text" name="name"><br>
<input type="button" value="로그인" onclick="loginChk()">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnAdminlogin").onclick = func1AdminLogin;
	document.getElementById("btnAdminHome").onclick = func1AdminHome;
}

</script>
</head>
<body>
<form action="admin_loginproc.jsp" name="adminloginform" method="post">
<table>
	<tr>
		<td colspan="2" style="text-align: left;">
		<br>** 관리자 로그인 **<br>
		</td>	
	</tr>
	<tr>
		<td> 관리자 ID: <input type="text" name="adminid"></td>
	</tr>
	<tr>
		<td> 관리자 비밀번호: <input type="text" name="adminpasswd"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:left;">
		<input type="button" value="로그인 수행" id="btnAdminlogin">
		<input type="button" value="메인페이지" id="btnAdminHome">
	</tr>
</table>
</form>

</body>
</html>
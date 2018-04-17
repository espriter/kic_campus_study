<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./resources/js/test.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btn").onclick = func;
}


</script>
</head>
<body>
** 입력 ** <p/>
<form action="login" method="get" name="frm">
i   d : <input type="text" name="id"><br>
pwd : <input type="text" name="pwd"><p/>
<input type="button" id="btn"  value="전송(get)">
</form>
</body>
</html>
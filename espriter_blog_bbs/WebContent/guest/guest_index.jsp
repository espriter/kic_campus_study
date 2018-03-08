<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIC 쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<table style="width: 90%">
	<tr>
		<td style ="font-size: 24px">전문 쇼핑몰</td>
		</tr>
</table>

<%@ include file="guest_top.jsp" %>
<table style="width: 90%">
<% if(memid != null){%>
		<tr style="text-align:center;">
		<td style="background-color:red">
		<b><font color="white"><b><%= memid %>님! 방문을 환영합니다.</font><br>
			<img src="../images/pic2.jpg" width="100%"/>
		</td>
	<tr>
<%}else{%>
		<tr style="text-align:center;">
		<td style="background-color:blue">
		<!-- <td style="background-image: url(../images/pic.jpg); background-size: 100%;
					background-size:100% font-size:20px;">  // 셀 배경으로 이미지 사용 가능-->
			<b><font color="white">고객님 어서오셩! 로그인 이후 사용하세요!</font></b>
			<img src="../images/pic.jpg" width="100%"/>
		</td>
	<tr>
<%}%>
</table>
<%@ include file="guest_bottom.jsp" %>		
</body>
</html>


<%@page import="pack.player.PlayerMgr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pack.player.PlayerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mgr" class="pack.player.PlayerMgr" />
<jsp:useBean id="bean" class="pack.player.PlayerBean"/>

<html>
<head>
<%
String num = request.getParameter("num");
bean = mgr.getData(num); // 해당 자료 불러오기 from BoardMgr.java
%>
<title>선수 정보 : <%=bean.getPlname() %></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/font.css">
</head>
<body bgcolor="d9d9d9" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<!-- 2번째 테이블 -->
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
	<tr>
	<td>
	<!-- 첫번째 테이블 -->
<table align="center" id="Table_01" width="809" height="500" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="3">
			<img src="images/playerstat_01.gif" width="555" height="315" alt=""></td>
		<td rowspan="5" background="images/playerstat_02.gif" width="253" height="500">
			<img src="http://espriter.pe.hu/as/player/<%=bean.getPlnum() %>.png" width="253" height="500">
			</td>
		<td>
			<img src="images/spacer.gif" width="1" height="315" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2" background="images/playerstat_03.gif" width="158" height="149">
		<!-- 선수 번호 -->
		<p align="center"><b><span style="font-size: 80px; color: rgb(255, 255, 255);"><%=bean.getPlnum() %></span></b></p>
			</td>
		<td colspan="2">
			<img src="images/playerstat_04.gif" width="397" height="89" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="89" alt=""></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="images/playerstat_05.gif" width="79" height="96" alt=""></td>
		<td rowspan="2" background="images/playerstat_06.gif" width="318" height="87">
			<p align="center"><b><span style="font-size: 180%; color: rgb(255, 255, 255);"><%=bean.getPlname() %></span></b></p>
			</td>
		<td>
			<img src="images/spacer.gif" width="1" height="60" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/playerstat_07.gif" width="158" height="36" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="27" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/playerstat_08.gif" width="318" height="9" alt=""></td>
		<td>
			<img src="images/spacer.gif" width="1" height="9" alt=""></td>
	</tr>
</table>
	
	
	</td>	
	</tr>


	<tr>
		<td colspan="2" background="images/bgimg2.jpg" width="100%" height="500">
		<table align="center"  width="70%" height="80px" cellpadding="0" cellspacing="0">
			<tr>
			<td height="60px" colspan="10"><p align="left"><b><span style="font-size: 25px; color: rgb(0, 0, 0);">선수 정보</span></b></p></td>
			</tr>
			<tr >
				<td rowspan="2" background="images/table_bg.jpg" width="172px" height="62px"></td><td bgcolor="white" valign="middle"><p align="center">번호</p></td><td bgcolor="white" valign="middle"><p align="center">국적</p></td><td bgcolor="white"><p align="center">신체 정보</p></td><td bgcolor="white"><p align="center">포지션</p>
				</td>			
			</tr>
			<tr>
			<td height="35px" bgcolor="white"><p align="center"><%=bean.getPlnum() %></p></td><td height="35px" bgcolor="white"><p align="center"><%=bean.getPlnatl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getPlphs() %></p></td><td bgcolor="white"><p align="center"><%=bean.getPlposition() %></p></td>
			</tr>		
		</table><br>		
		<table align="center"  width="70%" height="80px" cellpadding="0" cellspacing="0">
			<tr>
			<td height="60px" colspan="10"><p align="left"><b><span style="font-size: 25px; color: rgb(0, 0, 0);">통산 전적</span></b></p></td>
			</tr>
			<tr >
				<td rowspan="3" background="images/table_bg.jpg" width="172px" height="62px"></td><td bgcolor="white" valign="middle"><p align="center">Prem lge 득점</p></td><td bgcolor="white" valign="middle"><p align="center">Europe 득점</p></td><td bgcolor="white" valign="middle"><p align="center">FA Cup 득점</p></td><td bgcolor="white" valign="middle"><p align="center">Lge Cup</p></td><td bgcolor="white" valign="middle"><p align="center">C. Shield 득점</p></td><td bgcolor="white" valign="middle"><p align="center">총 득점</p></td>
			</tr>
			<tr>
			<td height="35px" bgcolor="white"><p align="center"><%=bean.getPremgl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getEuropegl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getFacupgl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getLgecupgl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getCsgl() %></p></td><td bgcolor="white"><p align="center"><%=bean.getTotalgl() %></p></td>
			</tr>
		</table><br>
			<table align="center" width="70%" height="150px">
			<tr>
			<td height="60px" colspan="10"><p align="left"><b><span style="font-size: 25px; color: rgb(0, 0, 0);">선수 스토리</span></b></p></td>
			</tr>
			<tr>
			<td bgcolor="white" widht="70%" height="200px">
			<p id="story" style="text-align: justify"><span style="font-size: 25px; color: rgb(207, 0, 0);"><%=bean.getPlcomment() %></span>
			</p></td>
			<tr>
		</table>
		</td>
	</tr>

</table>
</body>
</html>
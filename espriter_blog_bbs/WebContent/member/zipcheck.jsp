<%@page import="pack.member.ZipcodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>
<%
request.setCharacterEncoding("utf-8");
String check = request.getParameter("check");
String p_area3 = request.getParameter("area3");

ArrayList<ZipcodeBean> list = memberMgr.addressRead(p_area3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 체크</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
<script type="text/javascript">
window.onload = function() {
	document.getElementById("btnZipFind").onclick = dongCheck;
	document.getElementById("btnZipClose").onclick = function(){
		window.close();
	};
}

function dongCheck(){
	if(zipForm.area3.value === ""){ // zipform area3의 값이 "" 즉 없으면
		alert("검색할 동 이름을 입력하시오.");
		zipForm.area3.focus(); // focus 가져다 놓기
		return;
	}
	zipForm.submit();
}
function send(zipcode, a1, a2, a3, a4){
	//alert(zipcode);
	opener.document.regForm.zipcode.value = zipcode; // register.jsp의 regForm에 값을 주는 것
	var addr = a1 + " " + a2 + " " + a3 + " " + a4;
	opener.document.regForm.address.value = addr;
	window.close();
}


</script>
</head>
<body>
<b>** 우편번호 찾기</b>
<form action="zipcheck.jsp" name="zipForm" method="post">
<table>
	<tr>
		<td>
		동 이름 입력 : <input type="text" name="area3">
		<input type="button" value="검색" id="btnZipFind">
		<input type="button" value="닫기" id="btnZipClose">
		<input type="hidden" name="check" value="n">
		</td>
	</tr>
</table>
</form>
<%
if(check.equals("n")){
	if(list.isEmpty()){
%>
	<b>검색 결과가 없습니다</b>
<%		
	}else{
%>
	<table>
		<tr>
			<td>
			<%
			for(int i=0; i < list.size(); i++){
				ZipcodeBean bean = list.get(i);
				String zipcode = bean.getZipcode();
				String a1 = bean.getArea1();
				String a2 = bean.getArea2();
				String a3 = bean.getArea3();
				String a4 = bean.getArea4();
				if(a4 == null) a4 = "";
			%>
				<a href="javascript:send('<%= zipcode %>','<%=a1 %>','<%=a2 %>','<%=a3 %>','<%=a4 %>')">
				<%= zipcode %> <%=a1 %> <%=a2 %> <%=a3 %> <%=a4 %>
				</a><br>
			<%
			}
			%>
			</td>
		</tr>
	</table>
<%	
	}
}
%>	
</body>
</html>
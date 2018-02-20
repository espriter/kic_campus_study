<%@page import="java.util.ArrayList"%>
<%@page import="pack4.SawonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="process" class="pack4.DbProcess" ></jsp:useBean>
<%
String buser = request.getParameter("buser");
//부서이름에 대한 유효성 검사
boolean check =process.BuserCheck(buser);
if(check == false){
	response.sendRedirect("db_exam_sawon.html");
	return;
}

int tot_pay = 0;//급여 총합을 위한 변수
double avg =0; //급여 평균 계산을 위한 변수
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=buser %><br>

<table border = '1'>
	<tr><th>사번</th><th>이름</th><th>직급</th><th>성별</th>
<%
ArrayList<SawonDto> list = process.getDataAll(buser);
for(int i = 0; i < list.size(); i++){
	SawonDto dto = (SawonDto)list.get(i);
	tot_pay += Integer.parseInt(dto.getPay());
	if(dto.getGen().equals("남")){//성별이 남성인 경우 배경색을 파랑으로
%>
<tr style="background-color:blue;color:white;">
		<td><%=dto.getNo() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getJik() %></td>
		<td><%=dto.getGen() %></td>
	</tr>
<%		
	}else{//성별이 남성이 아닌경우 2가지 경우이므로 else 사용
%>	
	<tr style="background-color:red;color:white;">
		<td><%=dto.getNo() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getJik() %></td>
		<td><%=dto.getGen() %></td>
	</tr>
<%
	}
}
avg = tot_pay/list.size();
%>

</table><br>
근무 인원수 : <%=list.size() %><br>

부서 급여 평균 : <%=avg %>


</body>
</html>
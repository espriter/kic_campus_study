<%@page import="pack2.Gugudan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan + "출력<p>");

// 1. 직접 jsp에서 구구단 처리
int gu[] = new int[9];
for(int i = 1; i< 10; i++){ //1부터 시작해서 10보다 작게 1씩 플러스
	gu[i - 1] = dan * i;
}
for(int a = 0; a < 9; a++){
out.println(dan + " * " + (a + 1 ) + "=" + gu[a] + "&nbsp;&nbsp;");
}
%>

<hr>
<%
// 2. 계산처리를 별도 클래스로 작성 후 불러다 쓰기
Gugudan gugudan = new Gugudan();
int re[] = gugudan.compute(dan);
for(int a = 0; a< 9; a++){
	out.println(dan + "*" + (a + 1) + "=" + re[a] + "&nbsp;&nbsp;");
}
%>

</body>
</html>
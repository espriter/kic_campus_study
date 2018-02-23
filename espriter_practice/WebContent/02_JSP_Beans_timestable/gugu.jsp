<%@page import="pack2.Gugudan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beans를 활용한 구구단 출력</title>
</head>
<body>
<%
int dan = Integer.parseInt(request.getParameter("dan"));
out.println(dan + "출력<p>");
%>
<hr>
<%
// 2. 계산처리를 별도 클래스로 작성 후 불러다 쓰기
//Gugudan gugudan = new Gugudan();
Gugudan gugudan = Gugudan.getInstance(); //싱글톤 패턴
int re[] = gugudan.compute(dan);
for(int a = 0; a< 9; a++){
	out.println(dan + "*" + (a + 1) + "=" + re[a] + "&nbsp;&nbsp;");
}
%>
<hr>
** Beans 사용 **
<jsp:useBean id="gugu" class="pack2.Gugudan"/>
<!-- Gugudan gugu = new Gugudan() 한 것과 같은 효과 -->
<%
int re2[] = gugu.compute(dan);
for(int a = 0; a < 9; a++){
	out.println(dan + "*" + (a + 1) + "=" + re[a] + "&nbsp;&nbsp;");
}%>
</body>
</html>
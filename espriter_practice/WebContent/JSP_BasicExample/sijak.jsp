<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Test</title>
</head>
<body>
	jsp 연습
	<br>
	<script type="text/javascript">
		var a = 10; // java script
		document.write("a:", a);
	</script>

	<%
		int b = 10; // java code
		out.println("b:" + b);
	%>

	<br>
	<%
		//jsp는 service 메소드를 오버라이딩한 하나의 메소드가 곧 파일이다

		String ir = "홍길동"; // 지역 변수
		out.println(ir + "의 홈페이지입니다.");
	%>

	<h1>제목태그</h1>
	<h3>제목태그</h3>
	<h6>제목태그</h6>

	<%
		for (int i = 1; i < 7; i++) {
			out.println("<h" + i + ">");
			out.println("제목태그(자바로 작성)");
			out.println("</h" + i + ">");
		}
	%>
	<hr>
	<%
		out.println("자바로 ir 출력 : " + ir);
	%>
	<br>
	<%= new Date() %>
	<br>
	
	<%
	int a = 0, sum = 0; // 지역 변수
	do{
		a++;
		sum += a;
	}while(a <10);
	out.println("합은" + sum);
	%>
	<br>
	<%= "합은 " +sum %>
	<%= ir + "님의 전화번호:" + tel %>
	<%! String tel = "111-1111"; %> <!-- 클래스의 멤버 필드가 됨(전역변수) -->
<%!
	public int add(int m, int n) { // 클래스의 멤버 메소드가 됨
	return m + n;
	}	
%>
<br>
<% out.println(add(10,20)); %>
<br>
<%= add(100, 200) %>
<br>





</body>
</html>
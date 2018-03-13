<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"%>

<!-- isELIgnored="false"를 true로 쓰면 EL이 비활성화 -->
<!-- WEB-INF\lib 에 jstl-1.2.jar가 있어야 함 -->
<!--    http://tomcat.apache.org/taglibs/standard/ 에서 다운로드 가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL 연습</h2>
JSTL과 EL에 대해 궁금한 것은 <a href="http://hunit.tistory.com/203">http://hunit.tistory.com/203</a>를 참고하세요<br>
<br>--- 연산자 실습 ---<br>
\${3 + 4 } ==> ${3 + 4} <br>
백슬래시를 달면 EL 연산자가 비활성화 됨<br><br>
\${5 / 4 } ==> ${5 / 4} <!-- / 대신 div 가능 --><br>
\${5 / 0 } ==> ${5 / 0}<br>
<br><hr>
\${5 % 4 } ==> ${5 % 4}<br>
\${5 mod 4} ==> ${5 mod 4}<br>
<br><hr>
\${5 > 3 } ==> ${5 > 3}<br>
\${5 gt 3} ==> ${5 gt 3}<br>
<br><hr>
\${5 <= 4} ==> ${5 <= 4}<br>
\${5 le 4} ==> ${5 le 4}<br>
<br><hr>
\${5 > 3 and 10 > 5} ==> ${5 > 3 and 10 > 5}<br>
<br><hr>
\${5 > 4?10:20+5} ==> ${5 > 4?10:20+5}<br> 
<hr>


<br><hr>--- 내장객체 실습 ---<br>
<%
// 생존 기간이 다른 객체에 값 저장 후 출력
request.setAttribute("aa", "tiger");
session.setAttribute("bb", "lion");
application.setAttribute("cc", "eagle");
%>

<%=request.getAttribute("aa") %>, ${requestScope.aa}, ${aa}<br>
<%=session.getAttribute("bb") %>, ${sessionScope.bb}<br>
<%=application.getAttribute("cc") %>, ${applicationScope.cc}<br>
<br><hr>
전통적인 방식(legacy) : <%=request.getHeader("host") %>
EL : ${header.host}, ${header["host"]} <br>
<br><hr>

-- 컬렉션 객체 값 처리 -- <br>
<%
ArrayList<String> list = new ArrayList();
list.add("관우");
list.add("장비");
list.add("유비");
request.setAttribute("list", list);
%>
${list[0]}, ${list["1"]}
<hr>
-- html 문서로부터 자료 받기 -- <br>
<% request.setCharacterEncoding("utf-8"); %>
<a href="el2.html">html call</a><br>
이름 : ${param.irum}<br>
성격 : ${paramValues.sung[0]}, ${paramValues.sung[1]}
</body>
</html>
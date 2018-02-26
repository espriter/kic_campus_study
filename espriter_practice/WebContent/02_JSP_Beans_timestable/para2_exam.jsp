<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지용
    %>
    <jsp:useBean id="bean" class="pack2.FormBean"/>
    <!--
    <jsp:setProperty property="name" name="bean"/>
    <jsp:setProperty property="kor" name="bean"/>
    <jsp:setProperty property="eng" name="bean"/>
    -->
    <jsp:setProperty property="*" name="bean"/> <!-- 위 3줄을 *로 한번에 처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean을 활용해 입력값 출력하기</title>
</head>
<body>
<b>[예전 방법]</b> <br>
이름 : <%= bean.getName() %><br>
국어 : <%= bean.getKor() %><br>
영어 : <%= bean.getEng() %>
<br><br>
<b>[빈즈를 이용한 방법]</b><br>
이름 : <jsp:getProperty property="name" name="bean"/><br>
국어 : <jsp:getProperty property="kor" name="bean"/><br>
영어 : <jsp:getProperty property="eng" name="bean"/><br>
<br>
<hr>
<jsp:useBean id="process" class="pack2.ExamProcess"/>
<jsp:setProperty property="formBean" name="process" value="<%=bean%>"/>
총점은 <jsp:getProperty property="tot" name="process"/>
평균은 <jsp:getProperty property="avg" name="process"/>
</body>
</html>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
액션태그 역할:중복태그 별도 작성 후 호출
<br> 실행 결과가 원본 파일에 포함
<br> 홀수 출력:
<%
for (int a=1; a<=10; a++){
	if(a % 2 == 1)out.print(a + " ");
	}
out.println("<br>");
Date date = new Date();
%>

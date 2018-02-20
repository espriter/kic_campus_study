<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br>
액션태그로 값을 전달할 수 있다.
<br>
<% 
String param = request.getParameter("msg");
out.println("전달된 값은" + param);
%>
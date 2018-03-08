<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="jqdb" class="pack.jq13Db"></jsp:useBean>
<%
request.setCharacterEncoding("utf-8");
//폼빈 생략
String code = request.getParameter("code");
String sang = request.getParameter("sang");
String su = request.getParameter("su");
String dan = request.getParameter("dan");
//System.out.println(code + " " + sang + " " + su + " " + dan);

int re = jqdb.insertData(code, sang, su, dan);
if(re == 1){
	out.print("t");
}else{
	out.print("f");
}
%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String irum = request.getParameter("irum");
String nai = request.getParameter("nai");

String res = "[";
res += "{\"name\":" + "\""+ irum + "\",\"age\":" + nai + "}"; 
// \을 쓰는 이유 : escape로 인정됨 : \"내용\"
// {"name":"irum","age":"nai"} 
	
res += "]";
out.println(res);

%>
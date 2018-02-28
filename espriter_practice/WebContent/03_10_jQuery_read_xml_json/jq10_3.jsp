<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String irum = "홍길동";
String nai = "23";

String res = "[";
res += "{\"name\":" + "\""+ irum + "\",\"age\":" + nai + "}"; 
// \을 쓰는 이유 : escape로 인정됨 : \"내용\"
// {"name":"irum","age":"nai"} 
	
res += "]";
out.println(res);

%>
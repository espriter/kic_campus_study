<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="jqdb" class="pack.jq13Db"/>

<%
request.setCharacterEncoding("utf-8");

String code = request.getParameter("code");

int re = jqdb.deleteData(code);
if(re == 1){
	out.print("t");	
}else{
	out.print("f");
}
%>
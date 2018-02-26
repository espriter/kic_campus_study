<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="cajax" class="pack.ConnSuggest" />
<%
request.setCharacterEncoding("utf-8");
String keyword = request.getParameter("keyword");
//System.out.println(keyword);
ArrayList<String> list = cajax.getNames(keyword);
out.print(list.size());
out.print("|");
for(int i=0; i < list.size(); i++){
	String data = list.get(i);
	out.print(data);
	if(i < list.size() - 1){
		out.print(",");
	}
}
%>

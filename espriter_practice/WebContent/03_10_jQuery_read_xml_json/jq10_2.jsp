<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String irum = request.getParameter("irum");
%>
    
    
<persons>
	<person>
		<irum><%=irum%></irum>
	</person>
</persons>
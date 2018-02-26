<?xml version="1.0" encoding="UTF-8"?>
<%@page import="pack.ajax.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cdb" class="pack.ajax.ConnDb" />

<sangpums>
<% 
ArrayList<SangpumDto> list = cdb.getSangpumData(); 

for(int i = 0; i < list.size(); i++){
	SangpumDto dto = list.get(i);
%>
<sangpum>
	<code><%=dto.getCode() %></code>
	<sang><%=dto.getSang() %></sang>
	<su><%=dto.getSu() %></su>
	<dan><%=dto.getDan() %></dan>
</sangpum>
<%	
}
%>
</sangpums>


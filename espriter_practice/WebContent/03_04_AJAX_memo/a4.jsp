<?xml version="1.0" encoding="UTF-8"?>
<%@page import="pack.jikwonDto"%>
<%@page import="pack.jikwonDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cajax" class="pack.ConnAjax" />

<%
request.setCharacterEncoding("utf-8");
String buser = request.getParameter("buser");
//System.out.println(buser);
ArrayList<jikwonDto> list = cajax.getjikwonAll(buser);
out.print("<ele>");
for(jikwonDto j:list){
	out.print("<make>(" + j.getNo() + " " + j.getName() + ")</make>");
}
out.print("</ele>");
%>










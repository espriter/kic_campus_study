<%@page import="pack.ajax.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cdb" class="pack.ajax.ConnDb" />

{"sangpum":
[
<% 
ArrayList<SangpumDto> list = cdb.getSangpumData(); 
String result = "";

for(int i = 0; i < list.size(); i++){
	SangpumDto dto = list.get(i);
	result += "{";
	result += "\"sa_bun\":" + "\"" + dto.getCode() + "\"," ;
	result += "\"name\":" + "\"" + dto.getSang() + "\"," ;
	result += "\"jik\":" + "\"" + dto.getSu() + "\"," ;
	result += "\"ipsa_y\":" + "\"" + dto.getDan() + "\"" ;
	result += "},";
}
if(result.length() > 0){
	result = result.substring(0, result.length() - 1);
}
out.print(result);
%>
]}


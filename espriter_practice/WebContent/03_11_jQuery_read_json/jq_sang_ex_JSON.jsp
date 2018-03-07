<%@page import="pack.SangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cdb" class="pack.ConnDb"/>
<%
request.setCharacterEncoding("utf-8");
String sang = request.getParameter("sang");
ArrayList<SangpumDto> list = cdb.selSangpumData(sang);

String res = "[";

for(int i = 0; i < list.size() ;i++){
	SangpumDto dto = list.get(i);
	res += "{\"code\":" + "\"" + dto.getCode() + "\",\"sang\":" +"\""+ dto.getSang()
	+ "\",\"su\":"+ "\"" + dto.getSu() + "\",\"dan\":"+ "\"" + dto.getDan() +"\"},";
}
if(res.length()>0){
	res = res.substring(0, res.length() -1);
}
res += "]";
out.println(res);
%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String funcName = request.getParameter("callback");
if(funcName !=null){
%>
	<%=funcName %>(
	{"datas":
	[	
		{"no":"10","name":"에스프리터"},
		{"no":"10","name":"홍두깨"},
		{"no":"10","name":"고길동"}
	]
	}
	);
<%
}
%>
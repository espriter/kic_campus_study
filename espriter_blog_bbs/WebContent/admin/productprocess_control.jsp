<%@page import="pack.product.ProductMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>

<%
String flag = request.getParameter("flag");

boolean result = false;

if(flag.equals("insert")){
	result = productMgr.insertProduct(request);	
}else if(flag.equals("update")){
	result = productMgr.updateProduct(request);
}else if(flag.equals("delete")){
	result = productMgr.deleteProduct(request.getParameter("no")); 
}else{
	response.sendRedirect("productmanager.jsp");
}
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(result){
%>
	<script type="text/javascript">
	alert("정상적으로 처리되었습니다!!");
	location.href="productmanager.jsp";
	</script>
<%}else{%>
<script type="text/javascript">
	alert("오류가 발생하였습니다!!");
	location.href="productmanager.jsp";
	</script>

<%	
}
%>
</body>
</html>
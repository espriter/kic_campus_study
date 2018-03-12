<%@page import="pack.product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js">

</script>
</head>
<body>
<h2>** 대한민국 쇼핑몰 **</h2>
<%@include file="guest_top.jsp" %>

<table style="width:90%">
	<Tr style="background-color: gold">
		<th>상품</th><th>가격</th><th>재고량</th><th>상세보기</th>
	</Tr>
	
	<%
	ArrayList<ProductBean> list = productMgr.getProductAll();
	
	for(ProductBean p:list){
	%>
	<tr style="text-align: center;">
		<td><img src="../data/<%=p.getImage()%>" width="70"><br><%=p.getName() %></td>
		<td><%=p.getPrice() %></td>
		<td><%=p.getStock() %></td>
		<td><a href="javascript:productDetail_guest('<%=p.getNo()%>')">보기</td>
	</tr>
	<%	
	}
	%>
</table>

<%@include file="guest_bottom.jsp" %>

<form action="productdetail_guest.jsp" name="detailFrm" method="post">
	<input type="hidden" name="no">
</form>
</body>
</html>
















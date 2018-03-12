<%@page import="pack.product.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />

<%
String no = request.getParameter("no");
ProductBean bean = productMgr.getProduct(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js">

</script>
</head>
<body>
<h2>** 상품 상세보기 **</h2>
<%@include file="guest_top.jsp" %>
<form action="cartproc.jsp">
<table style="width: 90%">
	<tr>
		<td style="width: 20%">
			<img title="<%=bean.getName() %>" src="../data/<%=bean.getImage() %>" width="150">
		</td>
		<td style="width: 50%;  vertical-align: top;">
			<table style="width: 100%">
				<tr><td>번호 : </td><td><%=bean.getNo() %></td></tr>
				<tr><td>상품명 : </td><td><%=bean.getName() %></td></tr>
				<tr><td>가격 : </td><td><%=bean.getPrice() %></td></tr>
				<tr><td>등록일 : </td><td><%=bean.getSdate().substring(0,10) %></td></tr>
				<tr><td>재고량 : </td><td><%=bean.getStock() %></td></tr>
				<Tr>
					<td>주문 수량</td>
					<Td>
						<input type="text" name="quantity" value="1" size="5" style="text-align: center;">
					</Td>
				</Tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<Br>
						<input type="hidden" name="product_no" value="<%=bean.getNo() %>">
						<input type="submit" value="장바구니에 담기">
						<input type="button" value="이전화면으로" onclick="history.back()">
					</td>
				</tr>
			</table>
		</td>
		<td style="width: 30%; vertical-align: top;">
			<h4>상품 설명</h4 >
			<%=bean.getDetail() %>
		</td>
	</tr>
</table>
</form>
<%@include file="guest_bottom.jsp" %>
</body>
</html>

















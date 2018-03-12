<%@page import="pack.product.ProductMgr"%>
<%@page import="pack.product.ProductBean"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="pack.order.OrderMgr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="OrderMgr" class="pack.order.OrderMgr"/>
    <jsp:useBean id="ProductMgr" class="pack.product.ProductMgr"/>
    
    <%
    OrderBean order = OrderMgr.getOrderDetail(request.getParameter("no"));
    ProductBean product = ProductMgr.getProduct(order.getProduct_no());
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<h2> ** 주문 상세 보기 **</h2>
<%@ include file ="admin_top.jsp" %>
<form action="orderproc_admin.jsp" name="detailFrm" method="post">
<table style="width:90%" border="1">
	<tr>
		<td>고객 ID :<%=order.getId() %></td>
		<td>주문번호 :<%=order.getNo() %></td>
		<td>상품번호 :<%=order.getProduct_no() %></td>
		<td>상 품 명 :<%=product.getName() %></td>
	</tr>
	<tr>
		<td>상품 가격 :<%=product.getPrice() %></td>
		<td>주문 수량 :<%=order.getQuantity() %></td>
		<td>재 고 량 :<%=product.getStock() %></td>
		<td>주 문 일 :<%=order.getSdate() %></td>
	</tr>
	<tr>
		<td colspan="4">총 결재 금액 :
		<%=Integer.parseInt(order.getQuantity()) * Integer.parseInt(product.getPrice()) %>
	</td>
	</tr>	
	<tr>
	 	<td colspan="4" style="text-align:center;">
	 		주문상태 :
	 		<select name="state">
	 			<option value="1"> 접수</option>
	 			<option value="1"> 입금확인</option>
	 			<option value="1"> 배송준비</option>
	 			<option value="1"> 배송중</option>
	 			<option value="1"> 처리완료</option>	 			
	 		</select>
	 		<script type="text/javascript">
	 		 document.detailFrm.state.value = <%=order.getState()%>
	 		</script>
	 		<br>
	 	</td>
	</tr>
	<tr>
	 	<td colspan="4" style="text-align:center;">
	 	<input style="background:gold;" type="button" value="수 정"> -
	 	<input style="background:gold;" type="button" value="삭 제"> 
	 	</td>
	 </tr>
</table>
</form>
<%@ include file ="admin_bottom.jsp" %>
</body>
</html>
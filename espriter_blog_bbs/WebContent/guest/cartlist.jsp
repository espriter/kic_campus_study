<%@page import="pack.product.ProductBean"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cartMgr" class="pack.order.CartMgr"  scope="session" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 정보</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/script.js">

</script>
</head>
<body>
<h2>** 장바구니에 저장된 목록 **</h2>
<%@include file="guest_top.jsp" %>

<table style="width: 90%">
	<tr style="background-color: pink;">
		<th>주문상품</th><th>가격(소계)</th><th>수량</th><th>수정/삭제</th><th>조회</th>
	</tr>
	<%
	
	int totalPrice = 0;		//총계 구하기위해
	Hashtable hcart = cartMgr.getCartList();
	if(hcart.size() == 0){
%>
	<tr><td colspan="5">주문 건수가 없습니다.</td></tr>
<%
	}else{
		Enumeration enu = hcart.keys();
		while(enu.hasMoreElements()){
			OrderBean orderBean = (OrderBean)hcart.get(enu.nextElement());
			ProductBean productBean = productMgr.getProduct(orderBean.getProduct_no());
			
			int price = Integer.parseInt(productBean.getPrice());
			int quantity = Integer.parseInt(orderBean.getQuantity());
			int subTotal = price * quantity;		//소계
			
			totalPrice += subTotal;		//총계
			
%>

<tr>
	<td><%=productBean.getName() %></td>
	<td><%=subTotal %></td>
	<form action="cartproc.jsp" method="get">
			<input type="hidden" name="flag">
			<input type="hidden" name="product_no" value="<%=productBean.getNo() %>">
	<td><input type="text" name="quantity" value="<%=quantity %>" size="5" style="text-align: center;"></td>
	<td>
		<input style="background-color: silver;" type="button" value="수정" onclick="cartUpdate(this.form)">	
		<input style="background-color: silver;" type="button" value="삭제" onclick="cartDelete(this.form)">	
	</td>
	</form>
	<td><a href="javascript:productDetail_guest('<%=productBean.getNo()%>')">상세보기</a></td>
</tr>


<% 
		}
		
		%>
		<tr>
		<td colspan="5">
			<br>
			<b>총 결제 금액 : <%=totalPrice %></b>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="orderproc.jsp">[ 주문하기 ]</a>
		</td>
	</tr>
	<%	
	}
	%>
</table>
<%@include file="guest_bottom.jsp" %>

<form action="productdetail_guest.jsp" name="detailFrm" >
	<input type="hidden" name="no">
</form>
</body>
</html>




















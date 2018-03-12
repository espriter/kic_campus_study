<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="pack.product.ProductMgr"%>
<%@page import="pack.order.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 장바구니에 담긴 주문 상품 결제했다 가정하고 shop_order에 저장 -->
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/>
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr"/>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>

<%
Hashtable hcart = cartMgr.getCartList();

Enumeration enu = hcart.keys();
if(hcart.size() == 0){
%>	
	<script>
	alert("주문 내역이 없습니다!")
	location.href="productlist.jsp";
	</script>	
<%}else{
	while(enu.hasMoreElements()){
		OrderBean orderBean = (OrderBean)hcart.get(enu.nextElement());
		orderMgr.insertOrder(orderBean);	// 주문 자료 db에 넣기	
		productMgr.reduceProduct(orderBean); //주문 수만큼 재고량 빼기
		cartMgr.deleteCart(orderBean);
		}
%>
	<script>
	alert("주문 성공!")
	location.href="orderlist.jsp";
	</script>
<%
}
%>
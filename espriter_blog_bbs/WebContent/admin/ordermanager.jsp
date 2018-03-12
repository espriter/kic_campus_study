<%@page import="pack.product.ProductMgr"%>
<%@page import="pack.product.ProductBean"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="orderMgr" class="pack.order.OrderMgr"/>
    <jsp:useBean id="ProductMgr" class="pack.product.ProductMgr"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h2> ** 주문된 상품 목록 **</h2>
<%@ include file="admin_top.jsp" %>
<table style="width:90%">
	<tr style="background-color: cyan">
		<th>주문번호</th><th>주문고객 id</th><th>상품명</th><th>주문량</th><th>주문 날짜</th><th>주문 상태</th><th>보기</th>
	</tr>
	<%
	ArrayList<OrderBean> list = orderMgr.getOrderAll();
	if(list.size() == 0){
		%>
		<tr><td colspan="7">주문 내역이 없습니다</td></tr>
		
		
	<%	
	}else{
		for(int i=0; i < list.size(); i++){
			OrderBean order = (OrderBean)list.get(i);
			ProductBean product = 
					ProductMgr.getProduct(order.getProduct_no());
		%>
		<tr style="text-align: center;">
		<td><%=order.getNo() %></td>
		<td><%=order.getId() %></td>
		<td><%=product.getName() %></td>
		<td><%=order.getQuantity() %></td>
		<td><%=order.getSdate() %></td>	
		<td>
		<%
		switch(order.getState()){
		case "1":out.println("접수"); break;
		case "2":out.println("입금확인"); break;
		case "3":out.println("배송준비"); break;
		case "4":out.println("배송중"); break;
		case "5":out.println("처리완료"); break;
		default:out.println("접수중");
		}
		 %>
		</td>
		<td>
			<a href="javascript:orderDetail('<%=order.getNo()%>')">주문처리</a>
		</td>
		</tr>
		<%
		}
	}
	%>
</table>
<%@ include file="admin_bottom.jsp" %>


<form action="orderdetail.jsp" name="detailFrm" method="post">
<input type="hidden" name="no">
</form>
</body>
</html>
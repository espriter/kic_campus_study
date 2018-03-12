<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cartMgr" class="pack.order.CartMgr"  scope="session"/><!--  세션이 살아있는동안유효하는,, scope=session -->
<jsp:useBean id="order" class="pack.order.OrderBean" />
<jsp:setProperty property="*" name="order"/>

<%
String flag = request.getParameter("flag");		//구매정보 보기, 수정,삭제 판단용
String id = (String)session.getAttribute("idKey");
//out.print("id:" + id + " " + order.getProduct_no() + ",주문수 : " + order.getQuantity());

if(id == null){
	response.sendRedirect("login.jsp");		//로그인 하지 않았을때
}else{
	if(flag == null){
		order.setId(id);
		cartMgr.addCart(order);		//주문상품을 카트에 담기
%>
	<script>
	alert("장바구니에 담았습니다");
	location.href="cartlist.jsp";
	</script>
<%
	}else if(flag.equals("update")){
		order.setId(id);
		cartMgr.updateCart(order);
%>
	<script>
	alert("장바구니의 내용을 수정!");
	location.href="cartlist.jsp";
	</script>
<%
	}else if(flag.equals("del")){
		cartMgr.deleteCart(order);
%>
	<script>
	alert("해당 상품의 주문을 삭제했습니다!");
	location.href="cartlist.jsp";
	</script>
<%
	}
}

%>
















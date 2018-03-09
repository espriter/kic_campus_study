<%@page import="pack.product.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>
<%
String no = request.getParameter("no");
ProductBean bean = productMgr.getProduct(no);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@ include file="admin_top.jsp" %>
<table style="width:90%">
	<tr>
		<td style="width:20%">
			<img src="../data/<%=bean.getImage()%>" width="150">	
		</td>
		<td style="width: 50%; vertical-align:top;">
			<table style="width:100%">
			<tr><td>번호 : </td><td><%=bean.getNo()%></td></tr>
			<tr><td>상품명 : </td><td><%=bean.getName()%></td></tr>
			<tr><td>가격 : </td><td><%=bean.getPrice()%></td></tr>
			<tr><td>등록일 : </td><td><%=bean.getSdate().substring(0,10)%></td></tr>
			<tr><td>재고량 : </td><td><%=bean.getStock()%></td></tr>
			</table>
		</td>
		<td style="width:30%; vertical-align:top;">
		<b>* 상품설명 *</b><br>
			<%=bean.getDetail() %>
		</td>
	</tr>
	<tr>
		<td colspan="3" style="text-align: center;">
		<a href="javascript:ProductUpdate('<%=bean.getNo()%>')">수정하기</a>
		&nbsp;&nbsp;&nbsp;
		<a href="javascript:ProductDelete('<%=bean.getNo()%>')">삭제하기</a>
		</td>
	</tr>
</table>
<%@ include file="admin_bottom.jsp" %>
<form action="productupdate.jsp" name="updateForm" method="post">
<input type="hidden" name="no">
</form>

<form action="productprocess_control.jsp?flag=delete" name="delForm" method="post">
<input type="hidden" name="no">
</form>
</body>
</html>
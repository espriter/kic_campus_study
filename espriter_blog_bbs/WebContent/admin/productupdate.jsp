<%@page import="pack.product.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>
<%
ProductBean bean = productMgr.getProduct(request.getParameter("no"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">
window.onload = function() {
	document.getElementById("btnProductUpdate").onclick = function(){
		//수정 자료 검사
		document.productUpForm.submit();
	}
	
}

</script>
</head>
<body>
<%@ include file="admin_top.jsp" %>

<form action="productprocess_control.jsp?flag=update" method="post"
		 name="productUpForm" enctype="multipart/form-data"> <!-- enctype : 대용량 파일 전송시 필요 -->
<table style="width:90%; text-align:left;">
	<tr>
		<th><h2>** 상품 수정 **</h2></th>
	</tr>
	<tr>
		<td>상품명</td>
		<td><input type="text" name="name" value="<%=bean.getName() %>"></td>
	</tr>
	<tr>
		<td>가격</td>
		<td><input type="text" name="price" value="<%=bean.getPrice() %>"></td>
	</tr>
	<tr>
		<td>상품 설명</td>
		<td><textarea rows="5" cols="60" name="detail"><%=bean.getDetail() %></textarea></td>
	</tr>
	<tr>
		<td>재고수량</td>
		<td><input type="text" name="stock" value="<%=bean.getStock() %>"></td>
	</tr>
	<tr>
		<td>상품 이미지 등록</td>
		<td>
		<img src="../data/<%=bean.getImage()%>" width="150">
		<input type="file" name="image">
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<br>
		<input type="hidden" name="no" value="<%=bean.getNo()%>">
			<input type="button" value="상품수정" id="btnProductUpdate">
			<input type="reset" value="수정 취소"
							onclick ="history.back()">
			
		</td>
	</tr>
</table>
</form>
<%@ include file="admin_bottom.jsp" %>
</body>
</html>
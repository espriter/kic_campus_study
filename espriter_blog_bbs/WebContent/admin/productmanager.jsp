<%@page import="pack.product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr"/>

<!-- 파일 업로드 된걸 이클립스에서 확인하고 싶다면 메뉴 Window > Preference 선택 후
	General > Workspace > Refresh using native hooks or polling 체크 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script src="../js/script.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h2> ** 전체 상품 목록 - 관리자 화면 **</h2>
<%@ include file ="admin_top.jsp" %>
<table style="width: 90%">
	<tr style="background-color:orange;">
		<th>번호</th><th>상품명</th><th>가격</th><th>등록일</th><th>재고량</th><th>상세보기</th>
	</tr>
	<%
	ArrayList<ProductBean> list = productMgr.getProductAll();
	if(list.size() == 0){
	%>
	<tr><td colspan="6">등록된 상품이 없습니다</td></tr>
	<%
	}else{
		for(ProductBean p:list){
	%>
		<tr style ="text-align:center;">
			<td><%=p.getNo() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getSdate() %></td>
			<td><%=p.getStock() %></td>
			<td>
				<a href="javascript:productDetail('<%=p.getNo() %>')">보기</a>
			</td>
		</tr>
	<%
		}
	}
	%>
	<tr>
		<td colspan="6">
			<a href="productinsert.jsp">상품 등록</a>
		</td>
	</tr> 
			
</table>
<%@ include file ="admin_bottom.jsp" %>
<form action ="productdetail.jsp" name="detailForm" method="post">
<input type="hidden" name="no">

</form>
</body>
</html>
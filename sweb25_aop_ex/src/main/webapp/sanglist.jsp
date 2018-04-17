<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#showData").empty();
	
	$.ajax({
		type:"get",
		url:"sangpum",
		dataType:"json",
		success:function(data){
			//alert(data);
			var list = data.datas;
			var str = "<table style='width:40%; text-align:center;'>";
			str +="<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
			$(list).each(function(index, obj){
				str += "<tr>";
				str += "<td>" + obj["code"] + "</td>";
				str += "<td>" + obj["sang"] + "</td>";
				str += "<td>" + obj["su"] + "</td>";
				str += "<td>" + obj["dan"] + "</td>";
				str += "</tr>"; 
			});
			str+="</table>";
			$("#showData").append(str);
		},
		error:function(){
			$("#showData").text("err");
		}
	});
});
</script>
</head>
<body>
** 상품 목록 ** <p/>
<div id="showData"></div>
</body>
</html>
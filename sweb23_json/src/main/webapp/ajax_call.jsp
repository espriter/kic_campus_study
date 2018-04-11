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
	/*
	$("#btn1").click(function(){
		alert("aa");
		$("show").html("");
		
		$.ajax({
		type:"get",
		url:"list",
		data:{"name":"oscar"},
		dataType:"json",
		success:function(data){
			alert(data.name);
			var str = "";
			str += data.name + "<br>";
			str += skills[0] + " " + skills[1];
			$("#show").append(str);
			
		},
		error:function(){
			$("#show").text("자료 읽기 오류");
		}
		});
	});
	*/
	$("#btn2").click(function(){
		alert("aa");
		$("show").html("");
		
		$.ajax({
		type:"get",
		url:"list2",
		dataType:"json",
		success:function(data){
			alert(data.name);
			var str = "";
			var list = data.datas;
			
			$(list).each(function(index, obj){
				str += "<tr>";
				str += "<td>" + obj["name"] + "</td>";
				str += "<td>" + obj["age"] + "</td>";
				str += "</tr>";
			})
			str += "</table>";
			
			$("#show").append(str);
			
		},
		error:function(){
			$("#show").text("자료 읽기 오류");
		}
		});
	});
});
</script>


</head>
<body>
Json 읽기(from Spring)<p/>
<input type="button" value="한 개의 json 읽기" id="btn1"><br>
<input type="button" value="여러개의 json 읽기" id="btn2">
<hr>
<div id="show">

</div>
</body>
</html>
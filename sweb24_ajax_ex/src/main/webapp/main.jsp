<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	$("#buserSel").click(function() {
		$("#showGogek").empty();
		$("#showSawon").empty();
		$.ajax({
			type:"get",
			url:"sawon?buser_name="+$("#buserName").val(),
			dataType:"json",
			success:function(data){
				var list = data.datas;
				var str = "<table border='1'><tr><th>직원번호</th><th>직원명</th><th>부서전화</th><th>직급</th><th>관리고객</th></tr>";
				$(list).each(function(index, obj){
					str += "<tr>";
					str += "<td>" + obj["sawon_no"] + "</td>";
					if(obj["gogek_ct"] > 0){
						str += "<td>" + "<a href='javascript:showGogek("+ obj["sawon_no"] +")'>" +obj["sawon_name"] + "</a></td>";
					}else{
						str += "<td>" + obj["sawon_name"] + "</td>";
						}
					str += "<td>" + obj["buser_tel"] + "</td>";
					str += "<td>" + obj["sawon_jik"] + "</td>";
					str += "<td>" + obj["gogek_ct"] + "</td>";	
					str += "</tr>"
				});
				str += "</table>";
				$("#showSawon").append(str);
			},
			error:function(){
				$("#showSawon").text("부서명이 잘못되었습니다. 다시 입력해주세요");	
			}
		});
	});
	
});

$(document).on("mouseover", ".gogek", function(){
	$("#jumin"+this.id).show();
});

$(document).on("mouseout", ".gogek", function(){

	$("#jumin"+this.id).hide();
});

function showGogek(sawon_no){
	$("#showGogek").empty();
	$.ajax({
		type:"get",
		url:"gogek?sawon_no="+sawon_no,
		dataType:"json",
		success:function(data){
			var list = data.datas;
			var str = "<table border='1'><tr><th>고객번호</th><th>고객명</th><th>고객전화</th></tr>";
			$(list).each(function(index, obj){
				str += "<tr>";
				str += "<td>" + obj["gogek_no"] + "</td>";
				str += "<td id='"+obj["gogek_no"] +"' class='gogek'>" + obj["gogek_name"] + "</td>";
				str += "<td>" + obj["gogek_tel"] + "</td>";
				str += "<td style='display:none;' id='jumin"+obj["gogek_no"] +"'>" + obj["gogek_jumin"] + "</td>";
				str += "</tr>"
			});
			str += "<td colspan='3'>고객수 :"+ list.length +"명</td>"
			str += "</table>";
			$("#showGogek").append(str);
		},
		error:function(){
			$("#showGogek").text("데이터 접근 오류입니다.");	
		}
	});
}
</script>
</head>
<body>
<%
String id = (String)session.getAttribute("id");
if(id == null) {
	response.sendRedirect("login");
	return;
	}
%>
<%=id %>님 환영합니다.<br>
<a href="logout">로그아웃</a><br>
Json 처리문제 2<p/>
부서명:<input type="text" id="buserName"><input type="button" id="buserSel" value="확인">
<div id="showSawon">
</div>
<div id="showGogek">

</div>

</body>
</html>
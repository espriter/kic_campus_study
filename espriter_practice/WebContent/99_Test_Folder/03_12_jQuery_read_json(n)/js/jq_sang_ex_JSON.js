$(document).ready(function(){
	$("#btnAll").click(function(){
		$.ajax({
			type:"get",
			url:"jq_sang_ex_JSON.jsp?sang=all",
			dataType:"json",
			success:function(data){
				var ct=0;
				var str = "<table><tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th><th>금액</th></tr>";
				$.each(data,function(index, value){
					str += "<tr><td>" + value.code + "</td>";
					str += "<td>" + value.sang + "</td>";
					str += "<td>" + value.su + "</td>";
					str += "<td>" + value.dan + "</td>";
					str += "<td>" + (value.su*value.dan) + "</td>";
					str += "</tr>"
					ct++;
				});
				
				str += "<tr><td colspan='5'>건수:" + ct + "</td></tr>";
				$("#disp").html(str);
			}, 
			error:function(){
				$("#disp").text("에러 발생"); //뉴 새롭게 입력
			}
		});
	});
	$("#btnSel").click(function(data){
		$.ajax({
			type:"get",
			url:"jq_sang_ex_JSON.jsp?sang="+$("#sangName").val(),
			dataType:"json",
			success:function(data){
				if($("#sangName").val()===null || $("#sangName").val() ===""){
					alert("입력값을 넣어주세요");
					return;
				}
				var ct=0;
				var str = "<table><tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th><th>금액</th></tr>";
				$.each(data,function(index, value){
					str += "<tr><td>" + value.code + "</td>";
					str += "<td>" + value.sang + "</td>";
					str += "<td>" + value.su + "</td>";
					str += "<td>" + value.dan + "</td>";
					str += "<td>" + (value.su*value.dan) + "</td>";
					str += "</tr>"
					ct++;
				});
				str += "<tr><td colspan='5'>건수:" + ct + "</td></tr>";
				$("#disp").html(str);
				if(ct ===0){
					alert("검색한 상품이 없습니다.");
					$("#disp").html("검색 내역이 없습니다");
				}
			}, 
			error:function(){
				$("#disp").text("잘못된 접근입니다.");
			}
		});
	});
});
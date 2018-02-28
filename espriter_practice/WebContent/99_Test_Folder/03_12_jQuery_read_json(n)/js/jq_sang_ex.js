$(document).ready(function(){
	$("#btnAll").click(function(){
			$.ajax({
				type:"post",
				url:"jq_sang.jsp",
				data:{"irum":"장비", "nai":33}, // post 방식으로 호출하고 데이터를 장비,33살로 부름
				dataType:"json",
			success:function(data){
				var ct=0;
				var str = "<table><tr><th>이름</th><th>나이</th></tr>";
				$(data).find("sangpum").each(function(){
					str += "<tr><td>" + $(this).find("irum").text() + "</td>";
					str += "<td>" + $(this).find("nai").text() + "</td>";
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
			url:"jq_sang_ex.jsp?sang="+$("#sangName").val(),
			dataType:"xml",
			success:function(data){
				var ct=0;
				if($("#sangName").val()===null || $("#sangName").val() ===""){
					alert("입력값을 넣어주세요");
					return;
				}
				var str = "<table><tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th><th>금액</th></tr>";
				$(data).find("sangpum").each(function(){
					str += "<tr><td>" + $(this).find("code").text() + "</td>";
					str += "<td>" + $(this).find("sang").text() + "</td>";
					str += "<td>" + $(this).find("su").text() + "</td>";
					str += "<td>" + $(this).find("dan").text() + "</td>";
					str += "<td>" + ($(this).find("su").text()*$(this).find("dan").text()) + "</td>";
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
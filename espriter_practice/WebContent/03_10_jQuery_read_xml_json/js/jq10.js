$(document).ready(function(){
	//XML
	$("#btn1").click(function(){
		//alert("1");
		$.ajax({
			type:"get",
			url:"jq10_1.jsp",
			dataType:"xml",
			success:function(data){
				//alert(data);
				var str = "";
				$(data).find("person").each(function(){
					str += $(this).find("irum").text() + " ";
					// $("#disp").append(str); 이걸 사용하면 누적되게 됨
				});
				$("#disp").html(str);
			},
			error:function(){
				$("#disp").text("에러가 터졌음다");
				//$("#disp").html("data");
				//$("#disp").append("data");
			}
		});
	});
	
	$("#btn2").click(function(){ // para 0
		$.ajax({
			type:"post",
			url:"jq10_2.jsp",
			//data: "irum=" + "손오공&age=" + "손오공",
			data:{"irum":"사오정"}, // 이 방법이 조금 더 깔끔함
			dataType:"xml",
			success:function(data){
				var str = "";
				$(data).find("person").each(function(){
					str += $(this).find("irum").text() + " ";
				});
				$("#disp").html(str);
			},
			error:function(){
				$("#disp").text("에러가 터졌음다");
			}
		});
	});
	
	//JSON
	$("#btn3").click(function(){
		//alert("1");
		$.ajax({
			type:"get",
			url:"jq10_3.jsp",
			dataType:"json",
			success:function(data){//data는 임의로 지정한 값
				//alert(data);
				var ss = "";
				$.each(data, function(index, entry){ //데이터가 반복됨.
					ss += entry["name"] + ", " + entry.age; //["name"]아나 .name이나 동일하게 가능 
				});
				//$("#disp").append(ss); //append 이기 때문에 누적됨
				$("#disp").text(ss); //element가 있으면 html, 없으면 text
			},
			error:function(){
				$("#disp").text("에러가 터졌네요"); //id가 disp인 것에 표현
			}
			
		});
	});
	
	$("#btn4").click(function(){
		$.ajax({
			type:"post",
			url:"jq10_4.jsp",
			data:{"sangpum":"장수","irum":"장비", "nai":33}, // post 방식으로 호출하고 데이터를 장비,33살로 부름
			dataType:"json",
			success:function(data){//data는 임의로 지정한 값
				//alert(data);
				var ss = "";
				$.each(data, function(index, entry){ //데이터가 반복됨.
					ss += entry["name"] + ", " + entry.age; //["name"]아나 .name이나 동일하게 가능 
				});
				//$("#disp").append(ss); //append 이기 때문에 누적됨
				$("#disp").text(ss); //element가 있으면 html, 없으면 text
			},
			error:function(){
				$("#disp").text("에러가 터졌네요"); //id가 disp인 것에 표현
			}
			
		});
	});
	
});
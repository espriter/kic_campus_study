$(document).ready(function(){
	//1.html 등 의 text 문서 읽기
	$("#t1").click(function(){
		$("#disp").hide().load("jq9_a.html",function(){
			$(this).fadeIn(); // fade effect
		});
	});
	
	//2. json 문서 읽기
	$("#t2").click(function(){
		$.getJSON("jq9_b.json", function(data){
			$("#disp").empty();

			$.each(data, function(index, value){
				var ss = "<ol>";
				ss += "<li>" + value["title"] + "</li>";
				ss += "<li>" + value["desc"] + "</li>";
				ss += "<li>" + value["title"] + "</li>";
				ss += "</ol>";
				$("#disp").append(ss);
			});
		});
	});
	
	//3. xml 읽기
	$("#t3").click(function(){
		$("#disp").empty();
		$.get("jq9_c.xml", function(data){
		//$.post("jq9_c.xml", function(data){ //post 형태로도 가능
			//alert($(data).find("aa").size());
			$(data).find("aa").each(function(){
				var adata = $(this); // 현재 읽힌 aa 요소
				var ss = "<div>";
				// 속성 값 읽기
				ss += aadata.attr("part") + " " + aadata.attr("term");
				// 요소 값 읽기
				ss += " - ";
				ss += aadata.find("desc").text();
				ss+= "</div>";
				$("#disp").append(ss);
			})
			
		});
	});
});
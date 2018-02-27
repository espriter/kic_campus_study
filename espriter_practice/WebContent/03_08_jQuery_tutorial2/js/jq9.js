$(document).ready(function(){
	//1.html 등의 text 문서 읽기
	$("#t1").click(function(){
		$("#disp").load("jq9_a.html"); // load() : Ajax 관련 메소드
	});
	
	$("#t2").click(function(){
		$("#disp").load("jq9_b.json"); // load() : Ajax 관련 메소드
	});
	
	$("#t3").click(function(){
		$("#disp").load("jq9_c.xml"); // load() : Ajax 관련 메소드
	});
	
});
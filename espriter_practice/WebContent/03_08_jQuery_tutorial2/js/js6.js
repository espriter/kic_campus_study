$(document).ready(function(){
	var speech = $("div.speech");
	var defaultSize = speech.css("fontSize"); // 폰트 크기 얻기
	//alert(defaultSize); // 16px로 확인됨
	
	$("#switcher button").click(function(){
	//alert(parseFloat('123.2453abc')); //숫자만 체크해냄
	var fnum = parseFloat(speech.css("fontSize"));
	
	switch(this.id){ //현재 이벤트가 발생된 버튼
	case "sw-default":
		fnum = parseFloat(defaultSize);
		break;
	case "sw-large":
		fnum += 8; // num *=1.4 >> 비율로 값을 줄 때는 이렇게
	break;
	case "sw-small":
		fnum-= 8;
	}
	//speech.css("font-size",fnum +'px'); // 애니메이션 효과 없이 진행할 때
	speech.animate({fontSize:fnum +'px'}, 500); // 부드럽게 글자 크기를 키우고 싶을 때(속도 조절)
	// 숫자 말고도 'slow'나 'fast'로도 가능
	});


	$("#switcher button, a.more").hover(
		//hover(핸들러1, 핸들러2)
		function(){
			$(this).addClass('myhover');
		},
		function(){
			$(this).addClass('myhover');			
		}
	);
	
	// 문서 일부 show & hide
	var firstPara = $("p:eq(1)");
	firstPara.hide();
	
	$("a.more").on("click", function(){
		if(firstPara.is(":hidden")){
			//firstPara.show();
			//firstPara.fadeIn("fast"); //fade 효과
			firstPara.slideToggle("slow");
		}else{
			//firstPara.hide();
			//firstPara.fadeOut("fast"); //fade 효과
			firstPara.slideToggle("slow");
			$(this).text("read more");
		}
	});
	
});
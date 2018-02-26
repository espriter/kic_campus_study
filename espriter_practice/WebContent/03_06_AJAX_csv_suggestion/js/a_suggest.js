var xhr;
var checkFirst = loopSend = false;
var lastKeyword = "";

function sijak(){
	//console.log("a");
	if(checkFirst == false){
		setTimeout("sendKeyword()", 1000);
		loopSend = true;
	}
}

function sendKeyword(){
	if(loopSend == false) return;
	
	var keyWord = document.frm.keyword.value;
	//console.log(keyWord);
	if(keyWord === ""){
		lastKeyword = "";
		hide("suggest");
	}else if(keyWord !== lastKeyword){
		lastKeyword = keyWord;
		
		if(keyWord !== ""){
			var para = "keyword=" + keyWord;
			
			xhr = new XMLHttpRequest();
			xhr.open("post", "a_suggest.jsp", true);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status== 200){
						process();
					}else{
						alert("요청 실패: " + xhr.status);
					}	
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.send(para);	
		}else{
			hide("suggest");
		}
	}
	setTimeout("sendKeyword()", 1000);
}

function process(){
	var resultText = xhr.responseText;
	//alert(resultText);
	var result = resultText.split("|");
	//lert("전체 건수 : " + result[0] + "\n" + "자료 : " + result[1]);
	var tot = result[0];
	if(tot > 0){
		var datas = result[1].split(",");
		var imsi = "";
		for(var i=0; i < datas.length; i++){
			imsi += "<a href=\"javascript:func('" + 
					datas[i] + "')\">" + datas[i] + "</a><br>";
			//alert(imsi);
		}
		var listView = document.getElementById("suggestList");
		listView.innerHTML = imsi;
		show("suggest");
	}
}

function func(reData){
	frm.sel.value = reData;
	loopSend = checkFirst = lastKeyword = false;
	hide("suggest");
}

function hide(ele){
	var e = document.getElementById(ele);
	if(e) e.style.display = "none";
}

function show(ele){
	var e = document.getElementById(ele);
	if(e) e.style.display = "";
}

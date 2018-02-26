var xhr, popup, disp;

function goFunc(element){
	ele = element;
	//console.log(ele.id);
	disp = document.getElementById("disp");
	popup = document.getElementById("popup");
	
	xhr = new XMLHttpRequest();
	xhr.open("post", "a4.jsp", true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status== 200){
				//var datas = xhr.responseText;
				//alert(datas);
				var datas = xhr.responseXML;
				//alert(datas);
				
				setOffsets();   //툴팁박스 출현위치 지정
				var ss = "";
				var makes = datas.getElementsByTagName("make");
				for(var i = 0; i < makes.length; i++){
					ss += datas.getElementsByTagName("make")[i]
							.firstChild.nodeValue + " ";
				}
				//alert(ss);
				var r = createRow(ss);
				disp.appendChild(r); 
			}else{
				alert("요청 실패: " + xhr.status);
			}	
		}
	}
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("buser=" + ele.id);
}

function createRow(make){
	var row = document.createElement("tr");
	var col = document.createElement("td");
	var text = document.createTextNode(make);
	col.appendChild(text);
	row.appendChild(col);
	return row;
}

function setOffsets() {
    var end = ele.offsetWidth;
    /*
    부모노드 폭, offsetHeight:높이
    offsetWidth 속성 : offsetParent 설정에 따라 모체의 레이아웃이나 좌표에 상대적으로 계산된 너비 위치를 픽셀단위로 반환한다. 
    */
 
    var top = calcOffset(ele, "offsetTop");
    popup.style.left = end + 15 + "px";
    popup.style.top = top + "px";
    popup.style.border = "black 1px solid";
}

 

function calcOffset(field, attr) {
  var offset = 0;
  while(field) {
    offset += field[attr];    //부모 노드의 offsetTop 속성을 계속 더해 준다.
    field = field.offsetParent;
    /*
    offsetTop 속성 : offsetParent 설정에 따라 모체의 레이아웃이나 좌표에 상대적으로 계산된 수직 위치를 픽셀단위로 반환한다.
    */
  }
  return offset;
}


function clsFunc(){
	//console.log("clear");
	for(var i=disp.childNodes.length - 1; i >= 0; i--){
		disp.removeChild(disp.childNodes[i]);
	}
	popup.style.border = "none";
}







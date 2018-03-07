$(document).ready(function(){
	$("#addForm").hide();
	$("#delForm").hide();
	$("#code_err1").hide();
	$("#code_err2").hide();
	$("#sang_err").hide();
	$("#su_err").hide();
	$("#dan_err").hide();
	$("#dcode_err").hide();
	
	$("#btn_addSangpum").click(function(){
		$("#addForm").slideToggle("fast");
		$("#txtCode").focus();
	});
	
	$("#btn_delSangpum").click(function(){
		$("#delForm").slideToggle("fast");
		$("#delCode").focus();
	});
	
	$("#btn_dispAll").click(dispAll);  //전체자료 읽기
	$("#btn_insertData").click(insertData);  //추가
	$("#btn_deleteData").click(deleteData);  //삭제
	
	$("#btn_insertCancel").click(function(){ //추가 취소
		$("#txtCode").val("");
		$("#txtSang").val("");
		$("#txtSu").val("");
		$("#txtDan").val("");
		$("#addForm").slideToggle("fast");
	});
	
	$("#btn_deleteCancel").click(function(){ //삭제 취소
		$("#delCode").val("");
		$("#delForm").slideToggle("fast");
	});
});

function dispAll(){
	//alert("d");
	$.getJSON("jq13.jsp", function(data){
		$("#disp").empty();
		//alert(data);
		var str = "<table>";
		str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
		$.each(data, function(ind, entry){
			str += "<tr>";
			str += "<td>" + entry.code + "</td>";
			str += "<td>" + entry.sang + "</td>";
			str += "<td>" + entry.su + "</td>";
			str += "<td>" + entry.dan + "</td>";
			str += "</tr>";
		});
		str += "</table>";
		$("#disp").append(str);
	});
}

function insertData(){
	//alert("i");
	var code = $("#txtCode").val();
	var sang = $("#txtSang").val();
	var su = $("#txtSu").val();
	var dan = $("#txtDan").val();
	
	//code 입력자료 검사
	if(code.length < 1){
		$("#code_err1").show();
		return false;
	}else{
		$("#code_err1").hide();
	}
	
	for(var i = 0; i < code.length; i++){
		//charCodeAt : ascii 코드로 변환
		var data = code.charAt(i).charCodeAt(0); 
		//alert(data);
		if(data < 48 || data > 57){ //ascii 코드로 비교
			$("#code_err2").show();
			return false;
		}else{
			$("#code_err2").hide();
		}
	}
	
	//상품 검사
	if(sang.length < 1){
		$("#sang_err").show();
		return false;
	}else{
		$("#sang_err").hide();
	}
	
	//수량 검사
	if(isNaN(su) || su.length < 1){
		$("#su_err").show();
		return false;
	}else{
		$("#su_err").hide();
	}
	
	//단가 검사
	if(isNaN(dan) || dan.length < 1) {
		$("#dan_err").show();
		return false;
	}else{
		$("#dan_err").hide();
	}
	
	//추가 작업 진행
	$.ajax({
		type:"post",
		url:"jq13ins.jsp",
		data:{"code":code,"sang":sang,"su":su,"dan":dan},
		success:function(data){
			//alert(data);
			if(data.trim() === "f"){
				alert("추가 실패");
				return false;
			}
			alert("추가 성공");
			$("#txtCode").val("");
			$("#txtSang").val("");
			$("#txtSu").val("");
			$("#txtDan").val("");
			$("#addForm").slideToggle("fast");
			
			dispAll(); //추가 후 목록보기
		},
		error:function(){
			alert("상품추가 오류");
		}
	});
	
}
	//삭제 진행
function deleteData(){
	var code = $("#delCode").val();
	
	if(isNaN(code) ||code.length <1){
		$("#dcode_err").show();
		return false;
	}else{
		$("#dcode_err").hide();
	}
	
	$.ajax({
		type:"post",
		url:"jq13del.jsp",
		data:{"code":code},
		success:function(data){
			//alert(data);
			if(data.trim()===("f")){
				alert("삭제 실패");
				return false;
			}
			alert("삭제 성공");
			$("#delCode").val("");

			$("#delForm").slideToggle("fast");
			
			dispAll(); //추가 후 목록보기
		},
		fail:function(data){
			alert("삭제 실패!");
		}
	});

	
};

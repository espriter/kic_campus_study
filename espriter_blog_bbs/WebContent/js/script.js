function zipCheck(){
	url = "zipcheck.jsp?check=y";
	window.open(url,"post",
			"toolbar=no, width=350, height=300, top=200, left=300, status=yes, scrollbars=yes, menubar=no"); //우편물 post 얘기
}

function idCheck(){
	if(regForm.id.value === ""){
		alert("id를 입력하시구려");
		regForm.id.focus();
	}else{
		url = "idcheck.jsp?id=" + regForm.id.value;
		window.open(url, "","width=300,height=150,left=150,top=150");
	}
}

function inputCheck(){
	if(regForm.id.value == ""){
		alert("id 입력해!");
		regForm.id.focus();
		return;
	}
	if(regForm.passwd.value !== regForm.repasswd.value){
		alert("비번 틀렸어!");
		regForm.passwd.focus();
		return;
	}
	if(regForm.name.value == ""){
		alert("회원 이름 다시 입력해!");
		regForm.name.focus();
		return;
	}
	
	// 이메일, 전화번호... 얘네들 입력자료 검사(정규 표현식 추천) 생략...
	
	if(regForm.job.value == "0"){
		alert("엉뚱한거 고르지 말고 직업 제대로 다시 골라라");
		regForm.job.focus();
		return;
	}
	
	document.regForm.submit();
		
}

	function memberUpdateOk(){
		//입력자료 오류 검사는 생략
		document.updateForm.submit();
		
	}
	
	function memberUpdateCancel(){
		location.href="../guest/guest_index.jsp"
	}
	
	function memberDelete(){
		alert("회원 탈퇴는 불가(나중에 편집해보세요)");
	}
	
	// 관리자 관련 메뉴
	function func1AdminLogin(){
		if(adminloginform.adminid.value == ""){
			alert("id를 입력하시오");
			adminloginform.adminid.focus();
			return;
		}
		if(adminloginform.adminpasswd.value == ""){
			alert("Password를 입력하시오");
			adminloginform.adminpasswd.focus();
			return;
	}
		adminloginform.submit();
	}
	function func1AdminHome(){
		location.href="../index.jsp";
	}
	// 관리자 입장에서 각 회원 수정
	function memUpdate(id){ 
		//alert(id);
		document.updateFrm.id.value = id;
		document.updateFrm.submit(); // membermanager를 거쳐서 memberupdate_admin.jsp로 보냄
	}
	
	function memberUpdateAdmin(){
		document.updateFormAdmin.submit();
	}
	
	function memberUpdateCancelAdmin(){
		location.href ="membermanager.jsp";		
	}
	
	// 사용자에서 상품처리

	function productDetail_guest(no){
		document.detailFrm.no.value = no;
		document.detailFrm.submit();
	}
	
	// 관리자에서 상품 처리
	function productDetail(no){
		document.detailForm.no.value = no;
		document.detailForm.submit();
	}
	
	function ProductUpdate(no) { //productdetail.jsp 참고
		if(confirm("정말 수정하시겠습니까?")){
		document.updateForm.no.value = no;
		document.updateForm.submit();
		}
		
	}
	

	function ProductDelete(no) { // productdetail.jsp 참고
	if (confirm("정말 삭제하시겠습니까?")) {
		document.delForm.no.value = no;
		document.delForm.submit();
	}
}
	
// 카트 처리용
function cartUpdate(form){
		form.flag.value = "update";
		form.submit();
}

function cartDelete(form){
		form.flag.value = "del";
		form.submit();
}

// 관리자에서 주문 처리
function orderDetail(no){
	document.detailFrm.no.value = no; //detailFrm.은 ordermanager.jsp에서 확인 가능
	document.detailFrm.submit();
}


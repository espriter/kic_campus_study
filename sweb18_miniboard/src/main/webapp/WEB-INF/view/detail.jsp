<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload= function() {
	document.getElementById("btnList").onclick = function(){
		location.href="list";
	};
	
	document.getElementById("btnUpdate").onclick = function(){
		if(confirm("정말 수정?")){
			// 입력자료 오류 검사 생략
			frm.action = "update";
			frm.submit();
		}
	};
	
	document.getElementById("btnDelete").onclick = function(){
		if(confirm("정말 삭제?")){
			//frm.action="delete?num=" + frm.num.value;
			frm.action = "delete";
			frm.submit();			
		}
	};
	
}

</script>

</head>
<body>
* 상세보기 *<p/>
<form name="frm" method="post">
글 번호 : ${dto.num}
<input type="hidden" name="num" value="${dto.num}">
<br>
작성자 : <input type="text" name="author" value="${dto.author}"><br>
글제목 : <input type="text" name="title" value="${dto.title}"><br>
글내용 : <textarea rows="5" cols="50" name="content">${dto.content}</textarea><br>
작성일 : ${dto.bwrite}<br>
조회수 : ${dto.readcnt}<br>
<input type="button" value="목록" id="btnList">
<input type="button" value="수정" id="btnUpdate">
<input type="button" value="삭제" id="btnDelete">
</form>
</body>
</html>
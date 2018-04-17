<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.0.min.js" ></script>
<script type="text/javascript">

$(document).ready(function(){
    $("#btnList").on("click",function(){
    	$(location).attr('href',"list");
    });
    
    $("#btnUpdate").on("click",function(){
    	if(confirm("정말 수정할까요?")){
			$("#frm").attr("action","update").submit();
    	}
    });
    
    $("#btnDelete").on("click",function(){
    	if(confirm("정말 삭제할까요?")){
    		$("#frm").attr("action","delete").submit();
    	}
    })
});

</script>
</head>
<body>
** 상세 보기 **<p/>
<form name="frm" method="post">
글번호 : ${dto.num }<br>
<input type="hidden" name="num"  value="${dto.num }">
<Br>
작성자 : <input type="text"  name="author" value="${dto.author }"><br>
글제목 : <input type="text" name="title" value="${dto.title }"><br>
글내용 : <br>
<textarea rows="5" cols="50" name="content"  >${dto.content }</textarea><br>
작성일 : ${dto.bwrite }<br>
조회수 : ${dto.readcnt }<br><br>
<input type="button" value="목록보기"  id="btnList">
<input type="button" value="수정" id="btnUpdate">
<input type="button" value="삭제" id="btnDelete">
</form>
</body>
</html>
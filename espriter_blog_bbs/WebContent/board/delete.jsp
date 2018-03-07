<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr"/>
<jsp:useBean id="dto" class="pack.board.BoardDto"/>

<%
String num = request.getParameter("num");
String spage = request.getParameter("page");
dto = boardMgr.getData(num);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/board.css">
<script type="text/javascript">//수정을 위한 function
function check(){
	// 다른 건 생략
	if(frm.name.value === ""){
		frm.name.focus();
		alert("이름을 입력하시오");
		return false;
	}
	
	if(frm.pass.value === ""){
		frm.pass.focus();
		alert("비밀번호를 입력하시오");
		return false;
	}
	if(confirm("정말 수정하시겠습니까?")){
		frm.submit();
	}
}

</script>

</head>
<body>
<h2>** 글 수정 **</h2>
<form action="deletesave.jsp" method="post" name="frm">
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="page" value="<%=spage%>">
<table border ="1">
	<tr>
		<td> 이름 </td>
		<td> 
		<input type="text" name="name" value="<%=dto.getName() %>">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
		<input type="text" name="pass">
		</td>
	</tr>
		<tr>
		<td>이메일</td>
		<td>
		<input type="text" name="mail" value="<%=dto.getMail()%>">
		</td>
	</tr>
		<tr>
		<td>글 제목</td>
		<td>
		<input type="text" name="title" value="<%=dto.getTitle()%>">
		</td>
	</tr>
		<tr>
		<td>내용</td>
		<td>
		<textarea rows="10" cols="50 name="cont"><%=dto.getCont() %></textarea>
		</td>
	</tr>
	<tr>
	<td colspan="2" style="text-align: center";>
		<input type="button" value="삭제하기" onclick="check()">
		&nbsp;
		<input type="button" value="목록보기" onclick="location.href='boardlist.jsp?page=<%=spage%>'">
	</tr>
</table>


</form>
</body>
</html>
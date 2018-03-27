<%@page import="kr.mvc.model.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("btnUpdate").onclick = function(){
		if(confirm("정말 수정 할까요?")){
			f.command.value = "updateform";
			f.action = "updateform.m2";
			f.submit();
		}
	}
	
	document.getElementById("btnDelete").onclick = function(){
		if(confirm("정말 삭제 할까요?")){
			f.command.value = "delete";
			f.action = "delete.m2"
			f.submit();
		}
	}
	
	document.getElementById("btnList").onclick = function(){
		f.command.value = "list";
		f.action = "list.m2";
		f.submit();
	}
}
</script>
</head>
<body>
<table border="1">
	<tr>
		<td>아 이 디</td><td>${user.userid}</td>
		<Td>비밀번호</Td><td>${user.password}</td>
	</tr>
	<tr>
		<td>사 용 자</td><td>${user.name}</td>
		<Td>이 메 일</Td><td>${user.email}</td>
	</tr>
	<tr>
		<td colspan="4">
			<button id="btnUpdate">수정</button> 
			<button id="btnDelete">삭제</button> 
			<button id="btnList">목록</button> 
			
			<!--
			위에랑 같은것.  
			<input type="button" value="수정" id="btnUpdate">
			<input type="button" value="삭제" id="btnDelete">
			<input type="button" value="목록" id="btnList">
			-->
			
		</td>
	</tr>
</table>
<form name="f" method="post">
	<input type="hidden" name="command">
	<input type="hidden" name="userid" value="${userid}">
</form>
</body>
</html>














<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="memberBean" class="pack.member.MemberBean" scope="page"/>
<jsp:setProperty property="*" name="memberBean"/>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>


<%
String id = (String)session.getAttribute("idKey");
boolean b = memberMgr.memberUpdate(memberBean, id);

if(b){
%>
	<script>
	alert("수정 성공");
	location.href="../guest/guest_index.jsp;"
	</script>	
<%}else{ %>
	<script>
	alert("수정 실패\n 관리자에게 문의해라능!");
	history.back();
	</script>
<%
}
%>

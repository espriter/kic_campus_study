<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>


<jsp:useBean id="bean" class="pack.board.BoardBean" scope="page"/>
<jsp:setProperty property ="*" name="bean"/> 
<jsp:useBean id="boardMgr" class="pack.board.BoardMgr" scope="page"/>
<%
// 게시판 입력 자료를 내부적으로 처리
//System.out.println(bean.getName() + " " + bean.getTitle());
int newNum = boardMgr.currentGetmaxnum() + 1;
System.out.println("newNum : " + newNum);
bean.setNum(newNum);
bean.setBip(request.getRemoteAddr());
bean.setBdate();
bean.setGnum(newNum);

boardMgr.saveData(bean);

response.sendRedirect("boardlist.jsp"); //새글 등록 후 글 목록 보기
//boardMgr.saveData(bean);
%>
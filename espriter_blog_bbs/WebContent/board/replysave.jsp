<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bean" class="pack.board.BoardBean"/>
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="BoardMgr" class="pack.board.BoardMgr"/>

<%
String spage = request.getParameter("page");
//int num = bean.getNum();
int gnum = bean.getGnum();
int onum = bean.getOnum() + 1; // 댓글이기 때문에 1을 증가시켜야 함
int nested = bean.getNested() + 1; // 댓글이므로 1 증가

// 같은 그룹 내에서 새로운 댓글의 onum 보다 크거나 같은 값을
// 댓글 입력 전에 먼저 수정하기, 작으면 수정 안함
BoardMgr.updateOnum(gnum, onum); // onum 갱신

//댓글 자료 저장
bean.setOnum(onum);
bean.setNested(nested);
bean.setBip(request.getRemoteAddr());
bean.setBdate();
bean.setNum(BoardMgr.currentGetmaxnum() +1); // 댓글(새글)의 num 처리

BoardMgr.saveReplyData(bean);
response.sendRedirect("boardlist.jsp?page=" + spage);
%>
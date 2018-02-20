<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
 // 현재 jsp 파일의 용도는 html에서 넘어온 자료를 다른 jsp 파일을 호출하며 전달
 // 자료를 전달하기 위함, 클라이언트로 자료를 출력은 안함.
    String data=request.getParameter("data");
    String msg = "MR. " + data;

// 1. redirect 방식
//response.sendRedirect("jsp_call3.jsp?data=" + msg);
    
// 2. forward 방식
request.setAttribute("test",msg);

ArrayList<String> list = new ArrayList();
list.add("oscar");
list.add("james");
list.add("alex");
request.setAttribute("friends", list);

request.getRequestDispatcher("jsp_call3.jsp").forward(request, response);
%>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    %>
    
    <%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try{
    	Class.forName("org.mariadb.jdbc.Driver");
    	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
    	pstmt = conn.prepareStatement("select * from sangdata");
    	
    	rs = pstmt.executeQuery();
    }catch(Exception e){
    	System.out.println("err : " + e);
    }
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품자료</h2>
<table border="1"></table>
	<tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th></tr>
	<%
	while(rs.next()){
	%>
	<tr>
		<td><%out.println(rs.getString("code")); %></td>
	</tr>	
	<%
	}
	%>

</body>
</html>
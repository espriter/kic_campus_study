package pack.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BangInsert")
public class BangInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test","root","123");
			String sql="insert into miniguest(name,subject,content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);			
		} catch (Exception e) {
			System.out.println("연결실패 :" + e);
		}
	}

	public void destroy() {
		try {
			if(rs !=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			System.out.println("연결실패 :" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name"); // name 전송한 값 받기
		String subject  = request.getParameter("subject");
		String content  = request.getParameter("content");
		//System.out.println(name + " " + subject + " " + content);
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
			//response.sendRedirect("bang/bangins.html");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>" + name + "님 등록완료</b><br>");
			out.println("<html><body><b> 등록명은 " + subject + " 입니다</b><br>");
			out.println("<html><body><b> 내용은 " + content + " 입니다</b><br>");
			out.println("<br><br><a href='bang/bangins.html'>새글 등록하기</a>");
			out.println("<br><br><a href='BangList'>전체 글 보기</a>");
			
			out.println("</body></html>");
			out.close();

			
		} catch (Exception e) {
			System.out.println("doPost err: " + e);
		}
	}

}

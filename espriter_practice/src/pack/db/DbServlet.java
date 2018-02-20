package pack.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public void init() throws ServletException {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test","root","123");
		pstmt = conn.prepareStatement("select * from sangdata");
	} catch (Exception e) {
		System.out.println("연결실패 :" + e);
	}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>*상품자료*<br>");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				out.println(rs.getString("code") + " " + 
						rs.getString("sang") + " " +
						rs.getString("su") + " " +
						rs.getString("dan") + "<br>");
			}
			out.println("</body><html>");
			out.close();
			
		} catch (Exception e) {
			System.out.println("연결실패 :" + e);
		}
	}

		@Override
		public void destroy() {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				System.out.println("연결실패 :" + e);
			}
		}
	
}

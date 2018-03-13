package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class MemberDao1 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public MemberDao1() {
		try {
			//해킹 방지 안함
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123");
		} catch (Exception e) {
			System.out.println("MemberDao err : " + e);
		}
	}
	public boolean loginChk(String no, String name) {
		boolean b = false;
		try {
			String sql = "select * from sawon1 where sawon_name = ?";
			System.out.println(sql);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","123");
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			b = rs.next();
		} catch (Exception e) {
			System.out.println("loginChk err: " + e);
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null)pstmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e2) {
				
			}
		}
		return b;
	}
}

package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public MemberDao() {
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
			String sql = " select * from sawon where sawon_no=" + no + " and sawon_name=" + name + "";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			b = true;
		} catch (Exception e) {
			System.out.println("loginChk err: " + e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
			}
		}
		return b;
	}
}

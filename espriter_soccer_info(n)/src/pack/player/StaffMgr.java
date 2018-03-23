package pack.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class StaffMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public StaffMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");

		} catch (Exception e) {
			System.out.println("PlayerMgr err : " + e);
		}
	}

	public StaffBean getData(String num) {
		StaffBean mgr = null;
		try {
			String sql = " select * from stafftab where stnum=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mgr = new StaffBean();						
				mgr.setStnum(rs.getInt("stnum"));
				mgr.setStname(rs.getString("stname"));
				mgr.setStposition(rs.getString("stposition"));
				mgr.setStnatl(rs.getString("stnatl"));
				mgr.setStstory(rs.getString("ststory"));
			}
			
		} catch (Exception e) {
			System.out.println("getData err" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		
		return mgr;
	}
	
}

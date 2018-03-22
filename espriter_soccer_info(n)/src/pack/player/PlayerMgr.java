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



public class PlayerMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public PlayerMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");

		} catch (Exception e) {
			System.out.println("PlayerMgr err : " + e);
		}
	}

	public PlayerBean getData(String num) {
		PlayerBean mgr = null;
		try {
			String sql = " select * from playerinfo where plnum=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mgr = new PlayerBean();						
				mgr.setPlnum(rs.getInt("plnum"));
				mgr.setPlname(rs.getString("plname"));
				mgr.setPlnatl(rs.getString("plnatl"));
				mgr.setPlphs(rs.getString("plphs"));
				mgr.setPlposition(rs.getString("plposition"));
				mgr.setPlimage(rs.getString("plimage"));
				mgr.setPlcomment(rs.getString("plcomment"));
				mgr.setPremgl(rs.getString("premgl"));
				mgr.setEuropegl(rs.getString("europegl"));
				mgr.setFacupgl(rs.getString("facupgl"));
				mgr.setLgecupgl(rs.getString("lgecupgl"));
				mgr.setCsgl(rs.getString("csgl"));
				mgr.setTotalgl(rs.getString("totalgl"));	

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

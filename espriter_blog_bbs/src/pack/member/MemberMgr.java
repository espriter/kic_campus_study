package pack.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberMgr {
		private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		private DataSource ds;
	
	public MemberMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		} catch (Exception e) {
			System.out.println("BoardMgr err : " + e);
		}
	}
	public ArrayList<ZipcodeBean> addressRead(String p_area3) {
		ArrayList<ZipcodeBean> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select * from ziptab where area3 like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_area3 + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
			//System.out.println(rs.getString("area3"));
			ZipcodeBean bean = new ZipcodeBean();
			bean.setZipcode(rs.getString("zipcode"));
			bean.setArea1(rs.getString("area1"));
			bean.setArea2(rs.getString("area2"));
			bean.setArea3(rs.getString("area3"));
			bean.setArea4(rs.getString("area4"));
			list.add(bean);
			
				
			}
		} catch (Exception e) {
			System.out.println("addressRead err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return list;
	}
	
	public boolean checkId(String id) { // regform을 거쳐서 registerproc.jsp 로 날아감
		boolean b = false;
		try {
			String sql = "select id from member where id=?";
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			b = rs.next();	
		} catch (Exception e) {
			System.out.println("checkId err" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return b;
	}
	
	public boolean memInsert(MemberBean bean) {
		boolean b = false;
		try {
			conn = ds.getConnection();
			String sql = "insert into member values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPasswd());
			pstmt.setString(3, bean.getname());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getPhone());
			pstmt.setString(6, bean.getZipcode());
			pstmt.setString(7, bean.getAddress());
			pstmt.setString(8, bean.getJob());
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return b;
	}
}


package pack.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardMgr { // Board 관련 process
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	//paging
	private int tot = 0; // 전체 레코드 수
	private int pList = 5; // 한 페이지에 출력될 수
	private int pageSu = 0; // 전체 페이지 수
	
	
	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		} catch (Exception e) {
			System.out.println("BoardMgr err : " + e);
		}
	}
	
	public int currentGetmaxnum() { // board 테이블의 최대 num 구하기
		String sql = "select max(num) from board";
		int cnt = 0;
		try {
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(!rs.next()) cnt = 1;
			else cnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("currentGetmaxnum err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return cnt;
	}
	
	
	public void saveData(BoardBean bean) {
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			 
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPass());
			pstmt.setString(4, bean.getMail());
			pstmt.setString(5, bean.getTitle());
			pstmt.setString(6, bean.getCont());
			pstmt.setString(7, bean.getBip());
			pstmt.setString(8, bean.getBdate());
			pstmt.setInt(9,0); // readcnt
			pstmt.setInt(10,bean.getGnum());
			pstmt.setInt(11,0); //onum
			pstmt.setInt(12,0); //nested
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveData err: " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
	}
	
}
}
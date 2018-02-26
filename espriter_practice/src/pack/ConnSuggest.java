package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnSuggest {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ConnSuggest() {
	try {
		//context.xml 자원 읽기
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
	} catch (Exception e) {
		System.out.println("ConnAjax err : " + e);
	}
}
	public ArrayList<String> getNames(String keyword){
		ArrayList<String> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			String sql = "select sawon_name from sawon where sawon_name like ?";
			System.out.println("sql " + sql);
			System.out.println(keyword);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();	
			
		while(rs.next()) {
			list.add(rs.getString(1));
			System.out.println(rs.getString(1));
		}
		}catch (Exception e) {
			System.out.println("getNames err : " + e);
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
}
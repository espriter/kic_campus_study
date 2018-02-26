package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnAjax {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ConnAjax() {
		try {
			//context.xml 자원 읽기
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("ConnAjax err : " + e);
		}
	}
	public ArrayList<jikwonDto> getjikwonAll(String buser){
		ArrayList<jikwonDto> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select sawon_no, sawon_name from sawon " + 
			"inner join buser on buser_num=buser_no "+
					"where buser_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buser);
			rs = pstmt.executeQuery();
			String ss = "";
			while(rs.next()) {
				//ss += "(" + rs.getString(1) + " " + rs.getString(2) + ")";
				jikwonDto dto = new jikwonDto();
				dto.setNo(rs.getString(1));
				dto.setName(rs.getString(2));
				list.add(dto);
			}
			System.out.println(ss);
			
		} catch (Exception e) {
			//System.out.println("getJikwonDtoAll : " + e);
		} finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
}

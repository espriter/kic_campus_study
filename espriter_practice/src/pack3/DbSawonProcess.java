package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbSawonProcess { //jsp에서 호출될 비즈니스 로직을 가지고 있는 클래스

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DbSawonProcess() { //DAO
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("DbBuserProcess err: " + e);
		}
	}
	
	public ArrayList<SangpumDto> getDataAll(){
		ArrayList<SangpumDto> list = new ArrayList<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.54:3306/test", "root", "123");
			String sql = "select * from sawon";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("sawon_no"));
				dto.setSang(rs.getString("sawon_name"));
				dto.setSu(rs.getString("sawon_jik"));
				dto.setDan(rs.getString("sawon_gen"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getDataAll err" + e);
		} finally {
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

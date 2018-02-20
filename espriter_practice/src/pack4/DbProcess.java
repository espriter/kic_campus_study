package pack4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pack4.SawonDto;

public class DbProcess {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DbProcess() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
		}catch(Exception e) {
			System.out.println("DbProcess err : " + e);
		}
	}
	
	public boolean BuserCheck(String buser) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			String sql = "select buser_no from buser where buser_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,buser);
			rs = pstmt.executeQuery();
			if(rs.next()) {//해당 부서 이름이 있으면 true 반환
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
					return true;
				}catch(Exception e) {
					System.out.println("BuserCehck err : " + e);
				}
			}
			else if(rs.next()== false) {//해당 부서 이름이 있으면 false 반환
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
					return false;
				}catch(Exception e) {
					System.out.println("BuserCehck err : " + e);
				}
			}
			
		}catch(Exception e) {
			System.out.println("buserCheck err : " + e);
			return false;
		}
		return false;
	}
	
	public ArrayList<SawonDto> getDataAll(String buser){ //부서값을 받아 쿼리에 전달
		ArrayList<SawonDto> list = new ArrayList<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			String sql = "select sawon.sawon_no no, sawon.sawon_name name, "
					+ "sawon.sawon_jik jik, sawon.sawon_gen gen, sawon.sawon_pay pay  "
					+ "from sawon inner join buser on sawon.buser_num= buser.buser_no "
					+ "where buser.buser_name =?";//inner join 사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,buser);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SawonDto dto = new SawonDto();
				dto.setNo(rs.getString("no"));
				dto.setName(rs.getString("name"));
				dto.setJik(rs.getString("jik"));
				dto.setGen(rs.getString("gen"));
				dto.setPay(rs.getString("pay"));
				list.add(dto);
			}	
		}catch(Exception e) {
			System.out.println("getDataAll err : " + e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				System.out.println("getDataAll err : " + e);
			}	
		}
		return list;
	}
}

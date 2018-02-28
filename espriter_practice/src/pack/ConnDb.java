package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnDb {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ConnDb() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		}catch(Exception e) {
			System.out.println("DbProcess err : " + e);
		}
	}

	public ArrayList<SangpumDto> selSangpumData(String sang){
		//상품명을 전달받는 매소드
		ArrayList<SangpumDto> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "";
			if(sang.equals("all")) { 
				sql = "select * from sangdata";
				pstmt = conn.prepareStatement(sql);
			}else {//데이터 유효성은 js파일에서 별도의 조건을 주지 않음
				sql = "select * from sangdata where sang like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sang+'%'); //상품명 + @ 형태의 모든 데이터
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println("serSangpumData err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		
		return list;
	}
	
}


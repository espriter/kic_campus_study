package pack.jstl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PoolingDb {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	
	public PoolingDb() {
		try {
			//context.xml 자원 읽기
			Context context = new InitialContext(); //dbcp 사용
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		}catch(Exception e) {
			System.out.println("DbProcess err : " + e);
		}
	}
	public ArrayList<SangpumDto> getSangdata() {
		ArrayList<SangpumDto> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setDan(rs.getString("dan"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getSangData err : " + e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				
			}
		}
		return list;
	}
	
	public ArrayList<GogekDto> getGogekdata() {
		ArrayList<GogekDto> list = new ArrayList<>();
		
		try {
			conn = ds.getConnection();
			String sql = "select * from gogek";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GogekDto dto = new GogekDto();
				dto.setGogek_damsano(rs.getString("gogek_damsano"));
				dto.setGogek_jumin(rs.getString("gogek_jumin"));
				dto.setGogek_name(rs.getString("gogek_name"));
				dto.setGogek_no(rs.getString("gogek_no"));
				dto.setGogek_tel(rs.getString("gogek_tel"));
				list.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getGogekData err : " + e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				
			}
		}
		
		return list;
	}
	
	public SawonDto getSawondata(String no) {
			SawonDto dto = new SawonDto();
		try {
			conn = ds.getConnection();
			String sql = "select * from sawon where sawon_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setSawon_jik(rs.getString("sawon_jik"));
				dto.setBuser_num(rs.getString("buser_num"));
				dto.setSawon_name(rs.getString("sawon_name"));
				dto.setSawon_no(rs.getString("sawon_no"));
			}
		}catch(Exception e) {
			System.out.println("getSawonData err : " + e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {	
			}
		}
		return dto;
	}
}

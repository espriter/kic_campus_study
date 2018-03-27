package kr.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.mvc.controller.UserForm;

public class UserDaoModel {
	//비지니스로직(BL)을 수행
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public UserDaoModel() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		} catch (Exception e) {
			System.out.println("UserDaoModel err : " + e);
		} 
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		try {
			String sql = "select * from userinfo where userid=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDto();
				dto.setUserid(userid);
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			System.out.println("findUser err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
	public ArrayList<UserDto> getuserAll(){
		ArrayList<UserDto> list = new ArrayList<>();
		try {
			String sql = "select * from userinfo";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDto dto = new UserDto();
				dto.setUserid(rs.getString("userid"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getuserAll err : "  + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(conn!= null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		return list;
	}
	
	public int insertData(UserForm userForm) {
		int re = 0;
		
		try {
			String sql = "insert into userinfo values(?,?,?,?)";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userForm.getUserid());
			pstmt.setString(2, userForm.getPassword());
			pstmt.setString(3, userForm.getName());
			pstmt.setString(4, userForm.getEmail());
		
			re = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(conn!= null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		
		return re;
	}
	
	public int updateData(UserForm userForm) {
		int re = 0;
		
		try {
			String sql = "update userinfo set password=?,name=?,email=? where userid=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userForm.getPassword());
			pstmt.setString(2, userForm.getName());
			pstmt.setString(3, userForm.getEmail());
			pstmt.setString(4, userForm.getUserid());
			re = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn!= null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		
		return re;
	}
	
	
	
	public int deleteData(String userid) {
		int re = 0;
		
		try {
			String sql = "delete from userinfo where userid=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			re = pstmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn!= null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
		}
		
		return re;
	}
	
}


























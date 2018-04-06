package kr.co.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.controller.BoardBean;

@Repository
public class BoardDao implements BoardInter{
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Autowired
	public BoardDao(MyDataSource dataSource) {
		try {
			ds = dataSource;
			
		} catch (Exception e) {
			System.out.println("MyDataSource err" + e);
		}
		
	}
	
	public List<BoardDto> list() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql ="select * from miniboard order by num desc";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setAuthor(rs.getString("author"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setBwrite(rs.getString("bwriter"));
				dto.setReadcnt(rs.getInt("readcnt"));
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println("list err : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;
	}
	
	public List<BoardDto> search(String name, String value) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql ="select * from miniboard" + " where " + name + " like '%" + value + "%'" + " order by num desc";
			System.out.println(value);
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setAuthor(rs.getString("author"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setBwrite(rs.getString("bwriter"));
				dto.setReadcnt(rs.getInt("readcnt"));
				list.add(dto);
			}			
		} catch (Exception e) {
			System.out.println("list err : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public BoardDto detail(String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean writeData(BoardBean bean) {
		boolean b = false;
		try {
			conn = ds.getConnection();
			String sql ="insert into miniboard(author,title,content)values(?,?,?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getAuthor());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			if(pstmt.executeUpdate() > 0) b = true;			
		} catch (Exception e) {
			System.out.println("writeData err " + e);
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return b;
	}
	
	public boolean update(BoardBean bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean delete(String num) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}

package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl implements SangpumInter{
	public SangpumImpl(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("SanpumImpl err :" + e);
		}
	}
	
	@Override
	public void sangpumList() {
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "123");
			PreparedStatement pstmt = conn.prepareStatement("select * from sangdata;");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " +
						rs.getString(2) + " " + 
						rs.getString(3) + " " +
						rs.getString(4));				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("sangpumList err :" + e);
		}
	}

	@Override
	public void sangList() {
		// TODO Auto-generated method stub
		
	}


	
}

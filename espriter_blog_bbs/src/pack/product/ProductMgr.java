package pack.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pack.order.OrderBean;



public class ProductMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	
	public ProductMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		} catch (Exception e) {
			System.out.println("ProductMgr err : " + e);
		}
	}
	
	public ArrayList<ProductBean> getProductAll(){
		ArrayList<ProductBean> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select * from shop_product order by no desc;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			ProductBean bean = new ProductBean();
			bean.setNo(rs.getInt("no"));
			bean.setName(rs.getString("name"));
			bean.setPrice(rs.getString("price"));
			bean.setDetail(rs.getString("detail"));
			bean.setSdate(rs.getString("sdate"));
			bean.setPrice(rs.getString("price"));
			bean.setStock(rs.getString("stock"));
			bean.setImage(rs.getString("image"));
			list.add(bean);				
			}
		} catch (Exception e) {
			System.out.println("ProductBean err:" + e);
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
	
	public boolean insertProduct(HttpServletRequest request) {
		boolean b = false;
		try {
			//업로드할 이미지 경로(절대 경로)
			String uploadDir ="C:/Users/kitcoop/git/espriter_blog_practice_kic/espriter_blog_bbs/WebContent/data";
			//MultipartRequest multi=new MultipartRequest(request, savePath, sizeLimit, new DefaultFileRenamePolicy());
			MultipartRequest multi = new MultipartRequest(request, uploadDir, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			conn = ds.getConnection();
			String sql = "insert into shop_product(name, price, detail, sdate, stock, image) values(?,?,?,now(),?,?)"; //now는 sdate(지금) 의미
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  multi.getParameter("name"));
			pstmt.setString(2,  multi.getParameter("price"));
			pstmt.setString(3,  multi.getParameter("detail"));
			//sdate는 입력 안해도 자체적으로 생성됨
			pstmt.setString(4,  multi.getParameter("stock"));
			if(multi.getFilesystemName("image") == null) {
				//신상품 이미지를 택하지 않았을 경우 디폴트 이미지 선택
				pstmt.setString(5, "../images/ready.gif");
			}else {
				pstmt.setString(5,  multi.getFilesystemName("image"));
			}			
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			System.out.println("insertProduct err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return b;
	}
	
	public ProductBean getProduct(String no) {
		ProductBean bean = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from shop_product where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new ProductBean();
				bean.setNo(rs.getInt("no"));
				bean.setName(rs.getString("name"));
				bean.setPrice(rs.getString("price"));
				bean.setDetail(rs.getString("detail"));
				bean.setSdate(rs.getString("sdate"));
				bean.setStock(rs.getString("stock"));
				bean.setImage(rs.getString("image"));
			}		
		} catch (Exception e) {
			System.out.println("getProduct err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return bean;
	}
	public boolean updateProduct(HttpServletRequest request) {
		boolean b = false;
		try {
			String uploadDir ="C:/Users/kitcoop/git/espriter_blog_practice_kic/espriter_blog_bbs/WebContent/data";
			//MultipartRequest multi=new MultipartRequest(request, savePath, sizeLimit, new DefaultFileRenamePolicy());
			MultipartRequest multi = new MultipartRequest(request, uploadDir, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			conn = ds.getConnection();
			
			if(multi.getFilesystemName("image") == null) {
				String sql ="update shop_product set name=?, price=?, detail=?, stock=? where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,multi.getParameter("name"));
				pstmt.setString(2,multi.getParameter("price"));
				pstmt.setString(3,multi.getParameter("detail"));
				pstmt.setString(4,multi.getParameter("stock"));
				pstmt.setString(5,multi.getParameter("no"));
				
			}else {
				String sql ="update shop_product set name=?, price=?, detail=?, stock=?, image=? where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,multi.getParameter("name"));
				pstmt.setString(2,multi.getParameter("price"));
				pstmt.setString(3,multi.getParameter("detail"));
				pstmt.setString(4,multi.getParameter("stock"));
				pstmt.setString(5,multi.getFilesystemName("image"));
				pstmt.setString(6,multi.getParameter("no"));
			}
			if(pstmt.executeUpdate() > 0 ) b = true;			
		} catch (Exception e) {
			System.out.println("updateProduct err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
	
	return b;
}
	public boolean deleteProduct(String no) {
		boolean b = false;
		try {
			conn = ds.getConnection();
			String sql = "delete from shop_product where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,no);
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			System.out.println("deleteProduct err:" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
				
		return b;
		
	}
	
	public void reduceProduct(OrderBean order) {
		try {
			conn = ds.getConnection();
			String sql = "update shop_product set stock=stock - ? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getQuantity());
			pstmt.setString(2, order.getProduct_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("reduceProduct err:" + e);
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

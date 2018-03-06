package pack.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardMgr { // Board 관련 process
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	//paging
	private int tot = 0; // 전체 레코드 수
	private int pList = 5; // 한 페이지에 출력될 수
	private int pageSu = 0; // 전체 페이지 수
	
	
	public BoardMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		} catch (Exception e) {
			System.out.println("BoardMgr err : " + e);
		}
	}
	
	public int currentGetmaxnum() { // board 테이블의 최대 num 구하기
		String sql = "select max(num) from board";
		int cnt = 0;
		try {
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(!rs.next()) cnt = 1;
			else cnt = rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println("currentGetmaxnum err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
		return cnt;
	}
	
	
	public void saveData(BoardBean bean) {
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			 
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPass());
			pstmt.setString(4, bean.getMail());
			pstmt.setString(5, bean.getTitle());
			pstmt.setString(6, bean.getCont());
			pstmt.setString(7, bean.getBip());
			pstmt.setString(8, bean.getBdate());
			pstmt.setInt(9,0); // readcnt
			pstmt.setInt(10,bean.getGnum());
			pstmt.setInt(11,0); //onum
			pstmt.setInt(12,0); //nested
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveData err: " + e);
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
	public void totalList() {
		String sql = "select count(*) from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			tot = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("totallist err :" + e);
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
	
	public int getPageSu() { // 총 페이지 수 반환
		pageSu = tot / pList;
		if(tot % pList > 0)pageSu++;
		return pageSu;
	}
	public ArrayList<BoardDto> getDataAll(int page, String stype, String sword){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from board"; //order by gnum desc, onum asc";
		
		try {
			conn = ds.getConnection();
			if(sword == null) { //sword가 검색이 없을 경우
				sql += " order by gnum desc,onum asc";
				pstmt = conn.prepareStatement(sql);
			}else { // 검색이 있을 경우
				sql += " where " + stype + " like ?";
				sql += " order by gnum desc,onum asc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + sword + "%");
			}
			
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < (page -1) * pList; i++) {
				rs.next(); // 레코드 위치, 0, 4, 9...
			}
			int k = 0;
			while(rs.next() && k < pList) {
				BoardDto dto = new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setNested(rs.getInt("nested"));
				list.add(dto);				
				k++;
			}			
		} catch (Exception e) {
			System.out.println("getDataAll err" + e);
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
	public BoardDto getData(String num) {
		BoardDto dto = null;
		try {
			String sql = " select * from board where num=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new BoardDto();
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass")); //비밀번호
				dto.setMail(rs.getString("mail")); // 이메일
				dto.setTitle(rs.getString("title")); // 글제목
				dto.setCont(rs.getString("cont")); // 컨텐트
				dto.setBip(rs.getString("bip")); // ip 주소
				dto.setBdate(rs.getString("bdate")); // 등록일
				dto.setReadcnt(rs.getInt("readcnt")); // 조회수
			}
			
		} catch (Exception e) {
			System.out.println("getData err" + e);
		}finally {
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
	public void updateReadcnt(String num) {
		// 글 내용 보기 전에 조회수 증가 작업
		try {
			String sql = "update board set readcnt=readcnt + 1 where num=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateReadcnt err" + e);
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
	public BoardDto getReplyData(String num) { //댓글용
		BoardDto dto = null;
		try {
			String sql = "select * from board where num=?";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDto();
				dto.setTitle(rs.getString("title"));
				dto.setGnum(rs.getInt("gnum"));
				dto.setOnum(rs.getInt("onum"));
				dto.setNested(rs.getInt("nested"));
			}
			
		} catch (Exception e) {
			System.out.println("getReplyData err" + e);
		}finally {
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
	public void updateOnum(int gnum, int onum) {
		// 댓글용 - onum 갱신
		// 같은 그룹의 레코드는 모두 작업에 참여
		// 댓글의 onum은 이미 db에 있는 onum 보다 크거나 같은 경우에 변경
		try {
			String sql = "update board set onum=onum+1 where onum >= ? and gnum=?";
			conn = ds.getConnection();
			pstmt.getConnection().prepareStatement(sql);
			pstmt.setInt(1, onum);
			pstmt.setInt(2, gnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateOnum err" + e);
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
	public void saveReplyData(BoardBean bean) {
		// 댓글 저장
		try {
			String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getNum());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPass());
			pstmt.setString(4, bean.getMail());
			pstmt.setString(5, bean.getTitle());
			pstmt.setString(6, bean.getCont());
			pstmt.setString(7, bean.getBip());
			pstmt.setString(8, bean.getBdate());
			pstmt.setInt(9, 0);
			pstmt.setInt(10, bean.getGnum());
			pstmt.setInt(11, bean.getOnum());
			pstmt.setInt(12, bean.getNested());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("saveReplyData err" + e);
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
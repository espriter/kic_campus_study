package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{
	
	public MemberDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	//전체 자료 읽기
	/*
	public List<MemberDto> getMemberAll() {
		String sql = "select * from member";
		
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setName(rs.getString("name"));
			dto.setRegdate(rs.getString("regdate"));
			return dto;
			}
		});
		return list;
	}
	*/
	//전체 자료 읽기 / 페이지 나누기
	public List<MemberDto> getMemberAll(int startR, int endR) {
		String sql = "select * from member order by id asc limit ?,?";
		
		List<MemberDto> list = getJdbcTemplate()
				.query(sql, new Object[] {startR, endR}, new RowMapper() {
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setName(rs.getString("name"));
			dto.setRegdate(rs.getString("regdate"));
			return dto;
			}
		});
		return list;
	}
	
	public int getMemberCount() {//전체 레코드 건수(페이지 나누기용)
		String sql = "select count(*) from member";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
	// 추가 : jdbcDaoSupport
	public void insData(MemberBean bean) {
		String sql = "insert into member values(?,?,?,now())";
		Object[] args = {bean.getId(), bean.getPasswd(), bean.getName()};
		getJdbcTemplate().update(sql, args);
	}
	
	//부분 자료 읽기
	public MemberDto getMember(String id) {
		String sql = "select * from member where id=?";
		
		MemberDto dto = (MemberDto)getJdbcTemplate()
						.queryForObject(sql, new Object[]{id}, new RowMapper() {						
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setName(rs.getString("name"));
			dto.setRegdate(rs.getString("regdate"));
			return dto;
			}
		});
		return dto;
	}
	
	// 수정 : jdbcDaoSupport
	public void upData(MemberBean bean) {
		String sql = "update member set passwd=?, name=? where id=?";
		getJdbcTemplate().update(sql, new Object[] {bean.getPasswd(), bean.getName(),bean.getId()});
	}
	
	// 삭제 : jdbcDaoSupport
	public void delData(String id) {
		String sql = "delete from member where id=?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
	
}

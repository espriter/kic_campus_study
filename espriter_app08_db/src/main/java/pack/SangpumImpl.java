package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//스프링이 제공하는 JDBC 방법
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	
	public SangpumImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public List<SangpumDto> selectList() throws DataAccessException {
		RowMapper rowMapper = new SangRowMapper();
		return getJdbcTemplate()
				.query("select * from sangdata", rowMapper);
	}
	
	class SangRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// select 실행결과를 한 레코드 단위로 전달받아 처리
			System.out.println("rowNum : " + rowNum);
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}

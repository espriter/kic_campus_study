package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class SawonImpl extends JdbcDaoSupport implements SawonInter {
	public SawonImpl() {
	}
	
	@Autowired
	public SawonImpl(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override
	public List<SawonDto> selectList() throws DataAccessException{
			RowMapper mapper = new SawonRowMapper();
			
			String sql = "select * from sawon left join buser on buser_num=buser_no";
			return getJdbcTemplate().query(sql, mapper);
	}
	//내부 클래스
	class SawonRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException{
			SawonDto dto = new SawonDto();
			dto.setSawon_no(rs.getString("sawon_no"));
			dto.setSawon_name(rs.getString("sawon_name"));
			dto.setBuser_name(rs.getString("buser_name"));
			dto.setBuser_no(rs.getString("buser_no"));
			dto.setSawon_jik(rs.getString("sawon_jik"));
			return dto;
		}
	}
	
}

package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends SqlSessionDaoSupport implements DataInter{
	
	@Autowired
	public DataDao(SqlSessionFactory factory) {
		this.setSqlSessionFactory(factory);
	}
	
	public List<DataDto> sangpumList() {
		List<DataDto> list = getSqlSession().selectList("selectList");
		return list;
	}
}

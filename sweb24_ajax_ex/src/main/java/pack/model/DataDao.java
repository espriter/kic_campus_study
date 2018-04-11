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

	public List<SawonDto> sawonList(String buser_name) {
		List<SawonDto> list = getSqlSession().selectList("sawonList", buser_name);
		return list;
	}
	
	public List<GogekDto> gogekList(String sawon_no){
		List<GogekDto> list = getSqlSession().selectList("gogekList", sawon_no);
		return list;
	}
}

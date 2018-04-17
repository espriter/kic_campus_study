package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SawonImpl extends SqlSessionDaoSupport implements SawonInter{
	
	@Autowired
	public SawonImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<SawonDto> sawonList() {
		return getSqlSession().selectList("selectList");
	}
	
	public SawonDto getLogInfo(String no) {
		return getSqlSession().selectOne("selectLogin", no);
	}
	
}

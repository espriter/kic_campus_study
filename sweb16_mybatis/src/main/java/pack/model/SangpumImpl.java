package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.controller.SanpumBean;

@Repository
public class SangpumImpl extends SqlSessionDaoSupport implements SangpumInter{

	@Autowired
	public SangpumImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<SangpumDto> list() throws DataAccessException {
		return getSqlSession().selectList("selectDataAll");
	}
	
	
	public List<SangpumDto> search(SanpumBean bean) throws DataAccessException {
		return getSqlSession().selectList("selectSearch",bean);
		
	}
}

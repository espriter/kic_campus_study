package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSessionFactory(); 
	
	public List<DataDto> getDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession();	//세션 열기
		List<DataDto> list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectDataById(String code) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		DataDto dto = sqlSession.selectOne("selectDataById",code);
		sqlSession.close();
		return dto;
	}
	
	public void insData(DataFormBean bean) throws SQLException{		//원래는 dto말고 폼빈을 집어넣어야함 
		//SqlSession sqlSession = factory.openSession(true);		//auto commit => true
		SqlSession sqlSession = factory.openSession();		//수동- manual commit
		sqlSession.insert("insertData", bean);
		sqlSession.commit();		//수동일 경우 명시적으로 기술
		//sqlSession.rollback();
		sqlSession.close();
	}
	
	public void upData(DataFormBean bean) throws SQLException{
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("updateData", bean);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public boolean delData(int code){
		
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			int cou = sqlSession.delete("deleteData",code);
			if(cou > 0) {
				b = true;
				sqlSession.commit();
			}
			sqlSession.close();
			
		} catch (Exception e) {
			sqlSession.rollback();
			System.out.println("delData err: " + e);
		}
		
		return b;
		
	}
}
















package pack.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSessionFactory();
	
	public List<DataDto> selectDataAll(){
		SqlSession sqlSession = factory.openSession();
		List<DataDto> list = null;
		try {
			list = sqlSession.selectList("selectDataAll");
			
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	public DataDto selectDataPart(String id) {
		SqlSession sqlSession = factory.openSession();
		DataDto dto = null;
		try {
			dto = sqlSession.selectOne("selectDataPart", id);
		} catch (Exception e) {
			System.out.println("selectDataPart err : " + e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return dto;
	}
	
	
	public boolean insertData(DataFormBean bean) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		try {
			if(sqlSession.insert("insertData", bean) > 0) b = true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
	public boolean updateData(DataFormBean bean) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		try {
			// 비밀번호 비교 후 수정 여부 판단하는 코드 삽입
			DataDto dto = selectDataPart(bean.getId());
			if(dto.getPasswd().equals(bean.getPasswd())) {				
				b = true;
				sqlSession.commit();
			}
			if(sqlSession.update("updateData", bean) > 0) b = true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
	public boolean deleteData(String id) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		try {
			int cou = sqlSession.delete("deleteData", id);
			if(cou > 0) b = true;
			sqlSession.commit();

		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	
}	

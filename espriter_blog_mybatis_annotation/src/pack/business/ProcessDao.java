package pack.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.mybatis.SqlMapConfig;

public class ProcessDao {

	private SqlSessionFactory factory = SqlMapConfig.getSqlSessionFactory();

	public List<DataDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<DataDto> list = null;
		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			list = inter.selectdataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return list;
	}

	public DataDto selectDataPart(String id) {

		SqlSession sqlSession = factory.openSession();
		DataDto dto = null;
		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			dto = inter.selectdataPart(id);
		} catch (Exception e) {
			System.out.println("selectDataPart err : " + e);
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return dto;
	}

	public boolean insertData(DataFormBean bean) {
		boolean b = false;

		SqlSession sqlSession = factory.openSession();

		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);
			if (inter.insertData(bean) > 0)
				b = true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			sqlSession.rollback();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return b;
	}

	public boolean updateData(DataFormBean bean) {
		boolean b = false;

		SqlSession sqlSession = factory.openSession();

		try {

			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);

			// 비밀번호 비교 후 수정 여부 판단
			DataDto dto = inter.selectdataPart(bean.getId());

			if (dto.getPasswd().equals(bean.getPasswd())) { // bean.getpasswd는 클라이언트가 입력한 비번, dto.getpasswd는 디비에저장된 비번
				if (inter.updateData(bean) > 0)
					b = true;
				sqlSession.commit();
			}

		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			sqlSession.rollback();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return b;
	}

	public boolean deleteData(String id) {
		boolean b = false;

		SqlSession sqlSession = factory.openSession();

		try {
			SqlMapperInter inter = (SqlMapperInter) sqlSession.getMapper(SqlMapperInter.class);

			int cou = inter.deleteData(id);
			if (cou > 0)
				b = true;
			sqlSession.commit();

		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			sqlSession.rollback();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

		return b;
	}

}

package pack.mybatis;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.business.SqlMapperInter;

public class SqlMapConfig {
	public static SqlSessionFactory sessionFactory;
	
	static {
		String resource = "pack/mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			//MyBatis Annotation 사용 시 추가할 코드
			Class[] mappers = {SqlMapperInter.class};
			for(Class m:mappers) {
				//Mapper  등록
				sessionFactory.getConfiguration().addMapper(m);
			}
			
		} catch (Exception e) {
			System.out.println("SqlMapConfig err : " + e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
}





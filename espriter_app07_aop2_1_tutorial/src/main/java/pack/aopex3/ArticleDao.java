package pack.aopex3;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("db 자료 읽기 수행");
	}
}

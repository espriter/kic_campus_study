package pack.aopex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter {
	
	@Autowired
	@Qualifier("articleDao")
	private ArticleInter articleInter;
	
	//public LogicImpl(ArticleInter articleInter) {
		//this.articleInter = articleInter;
	//}
	
	@Override
	public void selectdata_process() {
		articleInter.selectAll();
		
	}
	
	@Override
	public void inserttdata_process() {
		// TODO Auto-generated method stub
		
	}
}

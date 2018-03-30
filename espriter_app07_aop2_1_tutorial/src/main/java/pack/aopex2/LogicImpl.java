package pack.aopex2;

public class LogicImpl implements LogicInter {

	private ArticleInter articleInter;
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
	}
	
	@Override
	public void selectdata_process() {
		articleInter.selectAll();
		
	}
	
	@Override
	public void inserttdata_process() {
		// TODO Auto-generated method stub
		
	}
}

package pack;

public class BusinessImpl implements BusinessInter{
	private SangpumInter sangpumInter;
	
	public void setSangpumInter(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	
	
	@Override
	public void dataList() {
		for(SangpumDto s:sangpumInter.selectList()) {
			System.out.println(s.getCode() + " " + 
					s.getSang() + " " + 
					s.getSu() + " " +
					s.getDan());
		}
	}
}

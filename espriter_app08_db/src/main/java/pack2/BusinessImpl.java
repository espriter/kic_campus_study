package pack2;

public class BusinessImpl implements BusinessInter{
	private SangpumInter sangpumInter;
	
	public void setSangpumInter(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	
	
	@Override
	public void dataList() {
		System.out.println("고객자료 출력(김씨만)");
				
		for(SangpumDto s:sangpumInter.selectList()) {
			System.out.println(s.getCode() + " " + 
					s.getSang() + " " + 
					s.getSu());
		}
		System.out.println("건수 : " );
	}
}

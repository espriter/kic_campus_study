package pack2;

public class ExamProcess {
	//비즈니스 로직용 클래스
	private FormBean formBean;
	
	public void setFormBean(FormBean formBean) {
		this.formBean = formBean;
	}
	
	// 총점 계산
	public int getTot() {
		return formBean.getKor() + formBean.getEng();
	}
	
	// 평균
	public double getAvg() {
		return getTot() / 2.0;
	}
}

package pack;

import org.springframework.stereotype.Component;

@Component
public class SangpumBean {			//폼빈 : command 객체
	private String sang;
	private int su, dan;
	public String getSang() {
		return sang;
	}
	public void setSang(String sang) {
		this.sang = sang;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
}

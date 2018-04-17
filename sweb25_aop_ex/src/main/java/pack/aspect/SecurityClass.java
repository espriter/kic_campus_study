package pack.aspect;

import org.springframework.stereotype.Component;

@Component
public class SecurityClass {

	//관심 사항 클래스
	public void mySecurity() {
		System.out.println("핵심 메소드 수행 전에 보안작업 실행");
	}
	
}

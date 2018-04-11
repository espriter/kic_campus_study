package pack.model;

import org.springframework.stereotype.Repository;

@Repository
public class MyModel implements MyModelInter{
	
	public String processMsg() {
		System.out.println("process msg core method");
		return "processmsg 반환 ";
	}
	
	
	public String businessMsg() {
		System.out.println("비즈니스 메시지 핵심 메소드");
		return "Businessmsg 반환";
	}
	
}

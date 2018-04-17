package pack.model;

import org.springframework.stereotype.Repository;

@Repository
public class MyModel implements MyModelInter{
	
	public String processMsg() {
		System.out.println("processMsg core method");
		return "processMsg 반환";
	}
	
	public String businessMsg() {
		System.out.println("businessMsg 핵심 메소드");
		return "businessMsg 반환";
	}
	
}

package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectBean {

	@Autowired
	private SecurityClass class1;
	
	//@Around("execution(public String processMsg()) or execution(public String businessMsg())")
	@Around("execution(public String processMsg()) or execution(* bu*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		class1.mySecurity();//핵심 메소드 전 관심사항 수행
		
		Object object = joinPoint.proceed();
		
		System.out.println("핵심 메소드 수행 후 처리됨");
		
		return object;
	}
	
}

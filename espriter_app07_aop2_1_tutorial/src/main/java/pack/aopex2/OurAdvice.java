package pack.aopex2;

import org.aspectj.lang.ProceedingJoinPoint;

public class OurAdvice {

	public Object nice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println(joinPoint.getSignature() + "메소드 수행 전 처리... ");
		Object object = joinPoint.proceed();
		System.out.println(joinPoint.getSignature() + "메소드 수행 후 처리... ");
		
		return object;
		
	}
	
}

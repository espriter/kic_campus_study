package pack.aopex3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OurAdvice {
	@Around("execution(public void selectdata_pro(..))") //OurAdvice에 있던 advice를 그냥 annotation 시킴
	public Object nice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println(joinPoint.getSignature() + "메소드 수행 전 처리... ");
		Object object = joinPoint.proceed();
		System.out.println(joinPoint.getSignature() + "메소드 수행 후 처리... ");
		
		return object;
		
	}
	
}

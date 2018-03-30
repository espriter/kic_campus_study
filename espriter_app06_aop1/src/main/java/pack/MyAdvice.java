package pack;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor{
	//MethodInterceptor : Around advice를 지원
	
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		//jointpoint에 삽입되어 동작할 코드를 기술함
		
		// 관심사항 : login, transaction, security...
		String methodName = arg0.getMethod().getName();
		System.out.println(methodName + "전에 수행");
				
		Object object = arg0.proceed(); // 핵심로직의 메소드 - sayHi()
		
		System.out.println("sayHi 이후에 처리");
		
		return object;
	}
}

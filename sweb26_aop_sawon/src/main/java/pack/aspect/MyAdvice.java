package pack.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

	@Autowired
	private LoginClass class1;
	
	@Around("execution(* kbs*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletResponse response = null;
		HttpServletRequest request = null;
		
		for(Object o : joinPoint.getArgs()) {
			if(o instanceof HttpServletResponse) {
				response = (HttpServletResponse)o;
			}
			if(o instanceof HttpServletRequest) {
				request = (HttpServletRequest)o;
			}
		}
			
			//세션 체크 후 로그인 상태가 아니면 로그인 창으로 이동
			
			if(class1.loginCheck(request, response)) {
				return null;
			}
			
			Object object = joinPoint.proceed();
			return object;
		}
}














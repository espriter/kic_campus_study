package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	
	@Autowired
	private SawonInter sawonInter;
	
	@Around("execution(public void dataList())")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("AOP 시작");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("사번 : ");
		String no = scanner.nextLine();
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		
		for(SawonDto s:sawonInter.selectList()) {
			if(no.equals(s.getSawon_no()) & name.equals(s.getSawon_name())) { //사원 이름과 번호가 일치하는지 확인
				Object object = joinPoint.proceed();
				System.out.println("AOP 종료");
				return object; //오브젝트를 가져가면 AOP 처리(로그인)
			}
		}
		System.out.println("로그인 실패");
		return null; //null을 가져가면 로그인 실패
	}
	
}

package test06;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect // 공통관심사항 구현 클래스임
public class MyAspect {
	@Pointcut("execution(* makeFood(..))")
	public void myPoint(){}
	
	@Around("myPoint()")
	public void myAround(ProceedingJoinPoint joinPoint){
		System.out.println("배가 고프다."); // before
		
		try {
			// 핵심관심사항(장어구이 or 떡볶이 만들기)
			joinPoint.proceed();
			//////////////////////////////////
			// 핵심 관심사항 정상 종료(after-returning)
			System.out.println("음식을 먹는다.");
		} catch (Throwable e) {
			// 핵심관심사항 수행 도중 예외발생해서 종료됨.after-throwing
			System.out.println("엄마를 부른다.");
			e.printStackTrace();
		} finally {
			// 어쨌건 핵심관심사항이 종료됨.after
			System.out.println("설거지를 한다.");
		}
	}
}

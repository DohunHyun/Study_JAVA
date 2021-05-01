package test07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 공통 관심사항 구현 클래스
@Component
@Aspect
public class MyAspect {
	// 선택할 핵심관심사항 메소드 이름이 makeFood 이며 
	// 반환형이 뭐든 상관없고 파라미터는 2개인 메소드를 모두 선택해라.
	@Pointcut("execution(* makeFood(*,*))")
	public void myPoint(){}
	
	@Before("myPoint()")
	public void beforeFood(JoinPoint joinPoint){
		Object[] params = joinPoint.getArgs();
		int a = (Integer)params[0];
		int b = (Integer)params[1];
		System.out.println("배가고프다.");
		System.out.println
			("before 에서 미리 a,b 를 받아봤다." +a+ "/" +b);
	}
	@AfterReturning(pointcut="myPoint()", returning="result")
	public void completeFood(Object result){
		System.out.println("음식을 먹는다.음식결과 : " + result);
	}
	@AfterThrowing("myPoint()")
	public void foodFire(){
		System.out.println("불나서 엄마 부름.");
	}
	@After("myPoint()")
	public void allFinish(){
		System.out.println("설거지를 한다.");
	}
}



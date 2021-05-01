package test05;

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
	@Pointcut("execution(void makeFood())")
	public void myPoint(){}
	
	@Before("myPoint()")
	public void beforeFood(){
		System.out.println("배가고프다.");
	}
	
	@AfterReturning("myPoint()")
	public void completeFood(){
		System.out.println("음식을 먹는다.");
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

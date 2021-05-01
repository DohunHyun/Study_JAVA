package test03;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
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

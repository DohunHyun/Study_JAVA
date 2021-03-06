package test04;

import org.aspectj.lang.JoinPoint;

// 공통 관심사항 구현 클래스
public class MyAspect {
	
	// before 조인포인트에 실행할 메소드
	public void beforeFood(JoinPoint joinPoint){
		Object[] params = joinPoint.getArgs();
		int a = (Integer)params[0];
		int b = (Integer)params[1];
		System.out.println("배가고프다.");
		System.out.println
			("before 에서 미리 a,b 를 받아봤다." +a+ "/" +b);
	}
	
	// after-returning 조인포인트에 실행할 메소드
	public void completeFood(Object result){
		System.out.println("음식을 먹는다.음식결과 : " + result);
	}
	
	// after-throwing 조인포인트에 실행할 메소드
	public void foodFire(){
		System.out.println("불나서 엄마 부름.");
	}
	
	// after에 실행할 메소드
	public void allFinish(){
		System.out.println("설거지를 한다.");
	}
}

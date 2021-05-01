package test02;

// 공통 관심사항 구현 클래스
public class MyAspect {
	// before 조인포인트에 실행할 메소드
	public void beforeFood(){
		System.out.println("배가고프다.");
	}
	
	// after-returning 조인포인트에 실행할 메소드
	public void completeFood(){
		System.out.println("음식을 먹는다.");
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

package aop_proxy;

public class Test {

	public static void main(String[] args) throws Exception {
		Person boy = new Boy();
		Person girl = new Girl();
		
		PersonProxy proxy = new PersonProxy();
		
		proxy.setBefore(new CBefore()); // proxy에 핵심관심사항 실행 전 before를 실행하도록 틀을 만들어놓음
		proxy.setAfter(new CAfter());
		proxy.setAfterReturning(new CAfterReturning());
		proxy.setAfterThrowing(new CAfterThrowing());
		
		proxy.setPerson(boy); //boy의 핵심관심사항을 틀에 끼어 넣음
		proxy.makeFood(100); //boy실행
		
		System.out.println();
		
		proxy.setPerson(girl); //girl의 핵심관심사항을 틀에 끼어넣음
		proxy.makeFood(100); //girl실행
	}
}

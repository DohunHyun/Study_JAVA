package test01;

import java.util.Random;

public class Boy implements Person{

	@Override
	public void makeFood() {
		System.out.println("배가 고프다.");
		try{
			/////////////// 핵심 관심사항///////////////////
			System.out.println("장어구이를 만든다.");
			if (new Random().nextBoolean())
				throw new Exception("불났음!!!!");
			////////////////////////////////////////////////
			// 정상 완료
			System.out.println("음식을 먹는다.");
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("엄마를 부른다.");
		} finally {
			System.out.println("설거지를 한다.");
		}
	}

}

package test07;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Boy implements Person {

	@Override
	public String makeFood(int a, int b) throws Exception {
		/////////////// 핵심 관심사항///////////////////
		System.out.println("장어구이를 만든다." +a+ "/" +b);
		if (new Random().nextBoolean())
			throw new Exception("불났음!!!!");
		////////////////////////////////////////////////
		return "장어 맛있음 ㅇㅇ";
	}

}

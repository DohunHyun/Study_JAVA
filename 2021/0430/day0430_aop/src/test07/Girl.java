package test07;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Girl implements Person {

	@Override
	public String makeFood(int a, int b) throws Exception {
		/////////////// 핵심 관심사항///////////////////
		System.out.println(a+"시에 만나서 "+b+"인분 만들어 먹자");
		System.out.println("떡볶이를 만든다.");
		if (new Random().nextBoolean())
			throw new Exception("불났음!!!!");
		////////////////////////////////////////////////
		return "매콤달콤 호로록";
	}

}

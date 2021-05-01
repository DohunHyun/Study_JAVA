package test02;

import java.util.Random;

public class Girl implements Person {

	@Override
	public void makeFood() throws Exception {
		/////////////// ÇÙ½É °ü½É»çÇ×///////////////////
		System.out.println("¶±ººÀÌ¸¦ ¸¸µç´Ù.");
		if (new Random().nextBoolean())
			throw new Exception("ºÒ³µÀ½!!!!");
		////////////////////////////////////////////////
	}

}

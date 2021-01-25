

public class Test1 {

	public static void main(String[] args) {
		int chunwon=0;
		int obaekwon=0;
		int baekwon=0;
		int osipwon=0;
		int sipwon=0;
		
		System.out.println("투입금액 : 10000원 ");
		System.out.println("상품금액 : 2530원 ");
		System.out.println("거스름돈 : 7470원 ");
		
		int input = 10000;
		int price = 2530;
		int change = input - price; // 7470
		
		chunwon = change/1000;
		change = change%1000;
		System.out.println("1000원 : " + chunwon + "장 ");

		
		obaekwon = change/500;
		change = change%500;
		System.out.println("500원 : " + obaekwon + "개 ");

	
		baekwon = change/100;
		change = change%100;
		System.out.println("100원 : " + baekwon + "개  ");

		
		osipwon = change/50;
		change = change%50;
		System.out.println("50원 : " + osipwon + "개  ");

		
		sipwon = change/10;
		System.out.println("10원 : "  + sipwon + "개  ");
	}

}
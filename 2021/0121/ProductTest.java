public class ProductTest {
    public static void main(String[] args) {
        TV tv = new TV(123,"쌈성", 30000, 20, 60, "OLED");
        Refrigerator refrigerator = new Refrigerator(5123, "삼성냉장고", 300000, 15, 60);

        TV tv1 = new TV();
        tv1.setSerialNum(1234);
        tv1.setName("삼성LEDTV");
        tv1.setPrice(20000);
        tv1.setQuantity(15);
        tv1.setInch(50);
        tv1.setDisplayType("LED");


        System.out.println("tv1의 디스플레이 타입은 " + tv1.getDisplayType());

        System.out.println(tv.toString());
        System.out.println(tv1.toString());
        System.out.println(refrigerator.toString());
    }
}

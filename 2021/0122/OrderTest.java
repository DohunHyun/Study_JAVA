import java.util.Scanner;

public class OrderTest {
    public static void main(String[] args) {
        OrderManager orderManager = OrderManager.getInstance();

        Scanner sc = new Scanner(System.in);

        int input = 0;

        orderManager.addMenu(new Food("123", "김치찌개", 7000, "김치로만든 찌개"));

        System.out.println(orderManager.searchMenuByName("김치"));



    }
}

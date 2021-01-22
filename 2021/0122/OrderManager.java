import java.util.Arrays;

public class OrderManager {
    private OrderManager() {

    }
    private static OrderManager instance = new OrderManager();
    public static OrderManager getInstance() {
        return instance;
    }
    private static final int MAX_MENU = 10;
    private Food[] foodMenu = new Food[MAX_MENU];
    private int menuCount = 0;

    public void addMenu(Food food){
        if(menuCount < MAX_MENU) {
            foodMenu[menuCount] = food;
            menuCount++;
        } else {
            System.out.println("메뉴 갯수가 꽉찼습니다. ");
        }
    }

    public void removeMenu(String orderNumber) {
        for(int i=0; i<menuCount; i++) {
            if(foodMenu[i].getOrderNumber().equals(orderNumber)) {
//                Food[]
//                System.arraycopy();
            }
        }


    }

    public Food searchMenuByOrderNumber(String orderNumber) {
        for(Food food : foodMenu) {
            if(food.getOrderNumber().equals(orderNumber)) return food;
        }

        return null;
    }

    public Food searchMenuByName(String name) {
        for(Food food : foodMenu) {
            if(food.getName().contains(name)) {
                return food;
            }
        }
        return null;
    }

}

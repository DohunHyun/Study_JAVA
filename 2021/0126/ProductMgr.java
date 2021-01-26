import java.util.Arrays;

public class ProductMgr {

    int MAX_SIZE = 100;
    Product[] products = new Product[MAX_SIZE];

    private int count = 0;

    public void add(Product product) {
        if(count < MAX_SIZE) {
            products[count] = product;
            count++;
        } else {
            System.out.println("최대 가능 저장수를 초과하였습니다.");
        }
    }

    public Product[] getList() {
//        Book[] result = new Book[count];
//
//        for(int i=0; i<count; i++) {
//            result[i] = books[i];
//        }
//        return result;

        return Arrays.copyOfRange(products, 0, count);
    }

    public Product searchBySerialNum(int serialNum) {
        for(int i=0; i<count; i++) {
            if(products[i].getSerialNum()==serialNum) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] searchByName(String name) {
        Product[] result;
        int countTemp=0;
        for(int i=0; i<count; i++) {
            if(products[i].getName().contains(name)) {
                countTemp++;
            }
        }
        result = new Product[countTemp];
        int index=0;
        for(int i=0; i<count; i++) {
            if(products[i].getName().contains(name)) {
                result[index] = products[i];
                index++;
            }
        }

        return result;
    }

    public Product[] getTV() {
        Product[] TVList;
        int countTemp=0;

        for(int i=0; i<count; i++) {
            if(products[i] instanceof TV) {
                countTemp++;
            }
        }

        TVList = new Product[countTemp];
        int index = 0;
        for(int i=0; i<count; i++) {
            if(products[i] instanceof TV) {
                TVList[index] = products[i];
                index++;
            }
        }
        return TVList;
    }

    public Product[] getRefrigerator() {
        Product[] RefrigeratorList;
        int countTemp=0;

        for(int i=0; i<count; i++) {
            if(products[i] instanceof Refrigerator) {
                countTemp++;
            }
        }

        RefrigeratorList = new Product[countTemp];
        int index = 0;
        for(int i=0; i<count; i++) {
            if(products[i] instanceof Refrigerator) {
                RefrigeratorList[index] = products[i];
                index++;
            }
        }
        return RefrigeratorList;
    }

    public void remove(int serialNum) {
        for(int i=0; i<count; i++) {
            if(products[i].getSerialNum()==serialNum) {
                products[i] = products[count-1];
                products[count-1] = null;
                count--;
            }
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i=0; i<count; i++) {
            totalPrice += (products[i].getPrice())*products[i].getQuantity();
        }
        return totalPrice;
    }
}

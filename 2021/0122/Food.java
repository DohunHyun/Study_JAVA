public class Food {
    String orderNumber;
    String name;
    int price;
    String describe;

    public Food() {

    }

    public Food(String orderNumber, String name, int price, String describe) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public String toString() {
        return "Food{" +
                "orderNumber='" + orderNumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

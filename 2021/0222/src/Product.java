import java.io.Serializable;

public class Product implements Serializable {
    int serialNum;
    String Name;
    int price;
    int quantity;

    public Product() {

    }

    public Product(int serialNum, String Name, int price, int quantity) {
        this.serialNum = serialNum;
        this.Name = Name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "serialNum=" + serialNum +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

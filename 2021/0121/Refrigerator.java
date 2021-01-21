public class Refrigerator {
    private int serialNum;
    private String Name;
    private int price;
    private int quantity;
    private int volume;

    public Refrigerator() {

    }

    public Refrigerator(int serialNum, String Name, int price, int quantity, int volume) {
        this.serialNum = serialNum;
        this.Name = Name;
        this.price = price;
        this.quantity = quantity;
        this.volume = volume;
    }

    public String toString() {
        return "시리얼넘버 : " + this.serialNum + ", 이름 : " + this.Name + ", 가격 : " + this.price +
                ", 재고수량 : " + this.quantity + ", 용량 : " + this.volume;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

public class Refrigerator extends Product{
    private int volume;

    public Refrigerator() {

    }

    public Refrigerator(int serialNum, String Name, int price, int quantity, int volume) {
        super(serialNum, Name, price, quantity);
        this.volume = volume;
    }

    public String toString() {
        return super.toString() + "용량 : " + this.volume;
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

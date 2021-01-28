public class TV extends Product{

    private int inch;
    private String displayType;

    public TV() {

    }

    public TV(int serialNum, String Name, int price, int quantity, int inch, String displayType) {
        super(serialNum, Name, price, quantity);
        this.inch = inch;
        this.displayType = displayType;
    }

    public String toString() {
        return super.toString() + ", 인치 : " + this.inch + ", 디스플레이타입 : " + this.displayType;
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

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }
}

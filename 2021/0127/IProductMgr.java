import java.util.ArrayList;

public interface IProductMgr {

    public void add(Product product);

    public ArrayList getList();

    public Product searchBySerialNum(int serialNum);

    public ArrayList searchByName(String name);

    public ArrayList getTV();

    public ArrayList getRefrigerator();

    public ArrayList getRef_400();

    public ArrayList getTV_50();

    public void changePrice(int serialNum, int price);

    public void remove(int serialNum);

    public int getTotalPrice();
}

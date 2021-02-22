import java.util.ArrayList;

public interface IProductMgr {

    public void add(Product product) throws DuplicateException;

    public ArrayList getList();

    public Product searchBySerialNum(int serialNum) throws CodeNotFoundException;

    public ArrayList searchByName(String name);

    public ArrayList getTV();

    public ArrayList getRefrigerator();

    public ArrayList getRef_400() throws ProductNotFoundException;

    public ArrayList getTV_50() throws ProductNotFoundException;

    public void changePrice(int serialNum, int price);

    public void remove(int serialNum);

    public int getTotalPrice();

    public void save();

    public void load();
}

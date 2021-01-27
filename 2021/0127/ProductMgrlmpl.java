import java.util.ArrayList;

public class ProductMgrlmpl implements IProductMgr {

    ArrayList<Product> products = new ArrayList<>();

    private static ProductMgrlmpl instance = new ProductMgrlmpl();
    private ProductMgrlmpl() {

    }

    public static ProductMgrlmpl getInstance(){
        return instance;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getList() {
        return products;
    }

    @Override
    public Product searchBySerialNum(int serialNum) {
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getSerialNum() == serialNum) {
                return products.get(i);
            }

        }
        return null;
    }

    @Override
    public ArrayList searchByName(String name) {
        ArrayList<Product> searchList = new ArrayList<>();
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getName().contains(name)) {
                searchList.add(products.get(i));
            }

        }
        return searchList;
    }

    @Override
    public ArrayList getTV() {
        ArrayList<Product> TVList = new ArrayList<>();
        for(int i=0; i<products.size(); i++) {
            if(products.get(i) instanceof TV) {
                TVList.add(products.get(i));
            }
        }
        return TVList;
    }

    @Override
    public ArrayList getRefrigerator() {
        ArrayList<Product> RefList = new ArrayList<>();
        for(int i=0; i<products.size(); i++) {
            if(products.get(i) instanceof Refrigerator) {
                RefList.add(products.get(i));
            }
        }
        return RefList;    }

    @Override
    public ArrayList getRef_400() {
        ArrayList<Refrigerator> RefList = getRefrigerator();
        ArrayList<Refrigerator> Ref400List = new ArrayList();
        for(int i=0; i<RefList.size(); i++) {
            if(RefList.get(i).getVolume() >= 400) {
                Ref400List.add(RefList.get(i));
            }
        }
        return Ref400List;
    }

    @Override
    public ArrayList getTV_50() {
        ArrayList<TV> TvList = getTV();
        ArrayList<TV> Tv50List = new ArrayList<>();
        for(int i=0; i<TvList.size(); i++) {
            if(TvList.get(i).getInch() >= 50) {
                Tv50List.add(TvList.get(i));
            }
        }
        return Tv50List;
    }

    @Override
    public void changePrice(int serialNum, int price) {
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getSerialNum() == serialNum) {
                products.get(i).setPrice(price);
            }
        }
    }

    @Override
    public void remove(int serialNum) {
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getSerialNum() == serialNum) {
                products.remove(i);
            }
        }
    }

    @Override
    public int getTotalPrice() {
        int totalPrice=0;

        for(Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }
}

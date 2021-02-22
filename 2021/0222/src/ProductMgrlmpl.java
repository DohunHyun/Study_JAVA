import java.io.*;
import java.util.ArrayList;

public class ProductMgrlmpl implements IProductMgr {

    ArrayList<Product> products = new ArrayList<>();

    private static ProductMgrlmpl instance = new ProductMgrlmpl();
    private ProductMgrlmpl() {
        LoadThread thread = new LoadThread();
        thread.start();
    }

    public static ProductMgrlmpl getInstance(){
        return instance;
    }

    @Override
    public void add(Product product) throws DuplicateException {
        for(Product product1 : products) {
            if(product.getSerialNum() == product1.getSerialNum()) throw new DuplicateException();
        }

        products.add(product);
    }

    @Override
    public ArrayList<Product> getList() {
        return products;
    }

    @Override
    public Product searchBySerialNum(int serialNum) throws CodeNotFoundException{
        for(int i=0; i<products.size(); i++) {
            if(products.get(i).getSerialNum() == serialNum) {
                return products.get(i);
            }
        }
        throw new CodeNotFoundException();
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
    public ArrayList getTV(){
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
    public ArrayList getRef_400() throws ProductNotFoundException{
        ArrayList<Refrigerator> RefList = getRefrigerator();
        ArrayList<Refrigerator> Ref400List = new ArrayList();
        for(int i=0; i<RefList.size(); i++) {
            if(RefList.get(i).getVolume() >= 400) {
                Ref400List.add(RefList.get(i));
            }
        }
        if(Ref400List.size()==0) throw new ProductNotFoundException();
        return Ref400List;
    }

    @Override
    public ArrayList getTV_50() throws ProductNotFoundException{
        ArrayList<TV> TvList = getTV();
        ArrayList<TV> Tv50List = new ArrayList<>();
        for(int i=0; i<TvList.size(); i++) {
            if(TvList.get(i).getInch() >= 50) {
                Tv50List.add(TvList.get(i));
            }
        }
        if(Tv50List.isEmpty()) throw new ProductNotFoundException();
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

    @Override
    public void save() {
        // 파일에  저장하기 위해 FileOutputStream을 생성 후 도서리스트 객체를 저장하기 위해 ObjectOutputStream을 생성한다.
        try(ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("book.dat"))){
            out.writeObject(products);	// 도서리스트 객체를 파일에 저장하기
        } catch (Exception e) {
            System.out.println("[SYSTEM]파일 쓰기에 실패하였습니다.");
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        File f = new File("product.dat");
        if(f.exists()) {	// 파일이 존재하면 파일에서 데이터 읽기
            // 파일에서 읽어오기 위해 FileInputStream을 생성 후 저장된 도서리스트 객체를 읽어오기 위해 ObjectInputStream을 생성한다.
            try(ObjectInputStream in  = new ObjectInputStream(new FileInputStream(f))){
                products = (ArrayList<Product>) in.readObject();			// 도서리스트 객체를 파일에서 읽어오기
            } catch (Exception e) {
                System.out.println("[SYSTEM]파일 읽기에 실패하였습니다.");
                e.printStackTrace();
            }
        }else {				// 파일이 존재하지 않으면 새로운 리스트 생성
            products = new ArrayList<Product>();
        }
    }


}

import java.io.IOException;
import java.util.ArrayList;

public class ProductTest {
    public static void main(String[] args) throws DuplicateException, CodeNotFoundException, ProductNotFoundException, IOException {
        ProductMgrlmpl productMgr = ProductMgrlmpl.getInstance();

        productMgr.add(new TV(1, "TV", 30000, 3, 50, "OLED"));
        productMgr.add(new Product(2, "cleaner", 10000, 5));
        productMgr.add(new Refrigerator(3, "Refrigerator", 50000, 2, 50));

        System.out.println("상품 전체 목록");
        ArrayList<Product> allList = productMgr.getList();
        for(Product product : allList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("TV 목록 ");
        ArrayList<Product> tvList = productMgr.getTV();
        for(Product product : tvList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("냉장고 목록");
        ArrayList<Product> refrigeratorList = productMgr.getRefrigerator();
        for(Product product : refrigeratorList) {
            System.out.println(product);
        }
        System.out.println();
        System.out.println();

        //400리터 이상 없을때
//        System.out.println("400L 이상 냉장고 검색 ");
//        ArrayList<TV> Ref400List = productMgr.getRef_400();
//        for(Product product : Ref400List) {
//            System.out.println(product);
//        }

        //400리터 이상 추가 후
        productMgr.add(new Refrigerator(5, "SAMSUNG Refrigerator ", 80000, 5, 400));
        System.out.println("400L 이상 추가 후 다시 검색 ");
        System.out.println("400L 이상 냉장고 검색 ");
        ArrayList<TV> Ref400List = productMgr.getRef_400();
        for(Product product : Ref400List) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        // 50인치 이상 없을때
        System.out.println("50인치 이상 TV 검색 ");
        ArrayList<TV> tvList50 = productMgr.getTV_50();
        for(Product product : tvList50) {
            System.out.println(product);
        }

        //추가 후
//        productMgr.add(new TV(4, "TV SAMSUNG", 50000, 2, 70, "OLED by SAMSUNG"));
//        System.out.println("50인치 이상 TV 검색 ");
//        ArrayList<TV> tvList50 = productMgr.getTV_50();
//        for(Product product : tvList50) {
//            System.out.println(product);
//        }

        System.out.println();
        System.out.println();

        System.out.println("상품 이름 포함 검색 : SAMSUNG");
        ArrayList<Product> searchNameList = productMgr.searchByName("SAMSUNG");
        for(Product product : searchNameList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("상품 번호 검색 : 1");
        Product searchSerialNumProduct = productMgr.searchBySerialNum(1);
        System.out.println(searchSerialNumProduct);

        System.out.println();
        System.out.println();

        //상품번호가 없는것을 검색했을때
//        System.out.println("상품 번호 검색 : 55");
//        Product searchSerialNumProduct1 = productMgr.searchBySerialNum(55);
//        System.out.println(searchSerialNumProduct1);

        //이미 있는 상품을 추가할 경우
//        System.out.println("이미 있는 상품을 추가할경우 ");
//        productMgr.add(new TV(1, "TV", 30000, 3, 40, "OLED"));


        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();

        System.out.println("상품 번호와 가격을 입력받아 가격을 변경할 수 있는 기능 ");
        System.out.println("상품 번호 : 2, 변경후가격 : 50");
        System.out.println("변경 전 리스트 ");
        for(Product product : allList) {
            System.out.println(product);
        }
        productMgr.changePrice(2, 50);
        System.out.println("변경 후 리스트 ");
        for(Product product : allList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("상품 삭제, 상품번호 : 1");
        System.out.println("삭제 전 리스트 ");
        for(Product product : allList) {
            System.out.println(product);
        }
        productMgr.remove(1);
        System.out.println("삭제 후 리스트 ");
        for(Product product : allList) {
            System.out.println(product);
        }


        System.out.println("재고 가격 총합 : " + productMgr.getTotalPrice());

        SaveThread saveThread = new SaveThread();
        saveThread.start();


    }
}

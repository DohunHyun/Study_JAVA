public class ProductTest {
    public static void main(String[] args) {
        ProductMgr productMgr = new ProductMgr();

        productMgr.add(new TV(1, "TV", 30000, 3, 60, "OLED"));
        productMgr.add(new Product(2, "cleaner", 10000, 5));
        productMgr.add(new Refrigerator(3, "Refrigerator", 50000, 2, 50));
        productMgr.add(new TV(4, "TV SAMSUNG", 50000, 2, 70, "OLED by SAMSUNG"));
        productMgr.add(new Refrigerator(5, "SAMSUNG Refrigerator ", 80000, 5, 70));

        System.out.println("상품 전체 목록");
        Product[] allList = productMgr.getList();
        for(Product product : allList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("TV 목록 ");
        Product[] tvList = productMgr.getTV();
        for(Product product : tvList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("냉장고 목록");
        Product[] refrigeratorList = productMgr.getRefrigerator();
        for(Product product : refrigeratorList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("상품 이름 포함 검색 : SAMSUNG");
        Product[] searchNameList = productMgr.searchByName("SAMSUNG");
        for(Product product : searchNameList) {
            System.out.println(product);
        }

        System.out.println();
        System.out.println();

        System.out.println("재고 가격 총합 : " + productMgr.getTotalPrice());



    }
}

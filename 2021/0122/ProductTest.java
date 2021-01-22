import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        ProductMgr productMgr = new ProductMgr();
        Scanner sc = new Scanner(System.in);

        int input;
        //1. 상품추가 2. 저장된상품검색 3. 상품번호검색 4. 상품번호삭제 5. 특정가격이하 검색

        while(true) {
            System.out.println("다음중 원하는 작업을 선택하세요. ");
            System.out.println("1. 상품추가 | 2. 저장된상품검색 | 3. 상품번호검색 | 4. 상품번호삭제 | 5. 특정가격이하 검색 | -1. 종료 ");
            input = sc.nextInt();
            if(input == -1) break;

            switch (input) {
                case 1:
                    sc.nextLine();
                    System.out.println("정보를 입력하세요");
                    System.out.println("num,name,price,amount");
                    String[] inputsentence = sc.nextLine().split(",");
                    productMgr.add(new Product(Integer.parseInt(inputsentence[0]),
                            inputsentence[1],
                            Integer.parseInt(inputsentence[2]),
                            Integer.parseInt(inputsentence[3])));
                    System.out.println("상품 추가 완료 ");
                    break;

                case 2:
                    System.out.println("모든 상품 검색 ");
                    for(Product p : productMgr.list()) {
                        if(p != null) System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("찾고싶은 상품의 번호를 입력하세요 ");
                    int searchNum = sc.nextInt();
                    System.out.println(productMgr.list(searchNum));
                    break;

                case 4:
                    System.out.print("삭제할 상품의 번호를 입력하세요 >>");
                    int productDelete = sc.nextInt();
                    productMgr.delete(productDelete);
                    break;

                case 5:
                    System.out.println("원하는 가격 이하의 상품을 검색합니다.");
                    System.out.println("원하는 가격을 입력해주세요 ");
                    int price = sc.nextInt();

                    for(Product p : productMgr.priceList(price)) {
                        if(p!=null) System.out.println(p);
                    }


                    break;

                    default:
                        System.out.println("잘못된 입력입니다.");
            }
            System.out.println();
            System.out.println();


        }

    }



}

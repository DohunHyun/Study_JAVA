public class ProductMgr {


    Product[] products = new Product[100];
    int count = 0;


    public void add(Product p) {
        if(count<100) {
            products[count] = p;
            count++;
        } else {
            System.out.println("재고가 가득 찼습니다.");
        }
    }

    public Product[] list() {
        return products;
    }

    public Product list(int num) {
        for(Product p : products) {
            if(num == p.getSerialNum()) {
                return p;
            }
        }
        return null;
    }

    public void delete(int num) {
        for(int i=0; i<count; i++) {
            if(products[i].getSerialNum() == num) {
                products[i] = products[count];
                products[count] = null;
                System.out.println("삭제되었습니다.");
            }
        }
    }
    public Product[] priceList(int price) {
        Product[] cheaperProduct = new Product[100];
        int tempcount=0;
        for(int i=0; i<count; i++) {
            if(products[i].getPrice() <= price) {
                cheaperProduct[tempcount] = products[i];
                tempcount++;
            }
        }
        return cheaperProduct;
    }


}

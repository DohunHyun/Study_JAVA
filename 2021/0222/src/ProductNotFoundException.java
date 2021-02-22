public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("그런 상품이 존재하지 않습니다.");
    }
}

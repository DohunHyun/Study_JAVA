public class CodeNotFoundException extends Exception {
    public CodeNotFoundException() {
        super("해당 상품 번호를 찾을 수 없습니다.");
    }
}

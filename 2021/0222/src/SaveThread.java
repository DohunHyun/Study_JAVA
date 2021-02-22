import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveThread extends Thread {

    public SaveThread() throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        // 파일에  저장하기 위해 FileOutputStream을 생성 후 도서리스트 객체를 저장하기 위해 ObjectOutputStream을 생성한다.
        try (ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream("product.dat"))) {
            out.writeObject(products);	// 도서리스트 객체를 파일에 저장하기
            System.out.println("[SYSTEM] 파일을 저장했습니다.");
        } catch (Exception e) {
            System.out.println("[SYSTEM]파일 쓰기에 실패하였습니다.");
            e.printStackTrace();
        }
    }
}

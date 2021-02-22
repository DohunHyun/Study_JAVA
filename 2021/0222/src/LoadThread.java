import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadThread extends Thread {
    public void run() {
        ArrayList<Product> products = new ArrayList<>();
        File f = new File("product.dat");
        if(f.exists()) {	// 파일이 존재하면 파일에서 데이터 읽기
            // 파일에서 읽어오기 위해 FileInputStream을 생성 후 저장된 도서리스트 객체를 읽어오기 위해 ObjectInputStream을 생성한다.
            try(ObjectInputStream in  = new ObjectInputStream(new FileInputStream(f))){
                products = (ArrayList<Product>) in.readObject();			// 도서리스트 객체를 파일에서 읽어오기
                System.out.println("[SYSTEM] 파일을 불러왔습니다.");
            } catch (Exception e) {
                System.out.println("[SYSTEM]파일 읽기에 실패하였습니다.");
                e.printStackTrace();
            }
        }else {				// 파일이 존재하지 않으면 새로운 리스트 생성
            products = new ArrayList<Product>();
        }
    }
}

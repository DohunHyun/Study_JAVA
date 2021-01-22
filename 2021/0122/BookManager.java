import java.util.Arrays;

public class BookManager {
    // singleton pattern //
    private BookManager() {

    }
    private static BookManager instance;
    public static BookManager getInstance() {
        if(instance==null) {
            instance = new BookManager();
        }
        return instance;
    }

    ///////////////////////


    private static int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];

    private int count = 0;

    public void add(Book book) {
        if(count < 100) {
            books[count] = book;
            count++;
        } else {
            System.out.println("최대 가능 저장수를 초과하였습니다.");
        }
    }

    public void remove(String isbn) {
        for(int i=0; i<count; i++) {
            if(books[i].getIsbn().equals(isbn)) {
                books[i] = books[count-1];
                books[count-1] = null;
                count--;
            }
        }
    }

    public Book[] getList() {
//        Book[] result = new Book[count];
//
//        for(int i=0; i<count; i++) {
//            result[i] = books[i];
//        }
//        return result;

        return Arrays.copyOfRange(books, 0, count);
    }

    public Book searchByIsbn(String isbn) {
        for(int i=0; i<count; i++) {
            if(books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }
}

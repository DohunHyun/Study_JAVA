
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        BookManager mgr = new BookManager();
        BookManager mgr = BookManager.getInstance();
        Scanner sc = new Scanner(System.in);

        int select;
        // 1:도서추가 2:도서검색 3:도서삭제 4:도서전체목록 -1:종료

       while(true) {
           System.out.println("다음중 원하는 작업을 선택하세요. ");
           System.out.println("1:도서추가 2:도서검색 3:도서삭제 4:도서전체목록 -1:종료 ");
           select = sc.nextInt();
           if(select == -1) break;

           switch (select) {
               case 1:
                   sc.nextLine();
                   System.out.println("ISBN,책제목,저자,출판사,가격,설명");
                   String[] input = sc.nextLine().split(",");
                   mgr.add(new Book(input[0], input[1], input[2], input[3],
                           Integer.parseInt(input[4]), input[5]));
                   System.out.println("책 추가 완료 ");
                   break;

               case 2:
                   System.out.print("검색할 책의 ISBN을 입력하세요 >>");
                   String isbnSearch = sc.next();
                   Book book = mgr.searchByIsbn(isbnSearch);
                   if(book==null) {
                       System.out.println("해당 ISBN은 존재하지 않습니다.");
                   } else {
                       System.out.println(book);
                   }
                   break;

               case 3:
                   System.out.print("삭제할 책의 ISBN을 입력하세요 >>");
                   String isbnRemove = sc.next();
                   mgr.remove(isbnRemove);
                   break;

               case 4:
                   for(Book b : mgr.getList()) {
                       System.out.println(b);
                   }
                   break;

                   default:
                       System.out.println("잘못된 입력입니다.");

           }

        }

        System.out.println("프로그램이 종료됩니다.");
    }
}

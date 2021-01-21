package com.ssafy.ws03.step3;

public class BookTest {
    public static void main(String[] args) {
        Book[] booklist = new Book[2];

        booklist[0] = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
        booklist[1] = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");

//        Book[] books = new Book[2];
//        books[0] = new Book("21424", "JavaPro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
//        books[1] = new Book();
//        books[1].setIsbn("35355");
//        books[1].setTitle("분석설계");
//        books[1].setAuthor("소나무");
//        books[1].setPublisher("jaen.kr");
//        books[1].setPrice(30000);
//        books[1].setDesc("SW 모델링");

        System.out.println("**********도서목록*************");
        for(Book book : booklist) {
            System.out.println(book.toString());
        }

//        for(Book book : books) {
//            System.out.println(book.toString());
//        }
    }
}

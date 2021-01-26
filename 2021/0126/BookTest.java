package com.ssafy.ws05.step3;

public class BookTest {
    public static void main(String[] args) {
        BookManager bookManager = BookManager.getInstance();

        bookManager.add(new Book("21324", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
        bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000,  "Java 응용"));
        bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
        bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1));


        System.out.println("도서 전체 목록");
        Book[] allList = bookManager.getList();
        for(Book book : allList) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println();

        System.out.println("일반 도서 목록 ");
        Book[] notMagazineList = bookManager.getBooks();
        for(Book book : notMagazineList) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println();

        System.out.println("잡지 목록");
        Book[] magazineList = bookManager.getMagazine();
        for(Book book : magazineList) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println();

        System.out.println("도서 제목 포함 검색 : Java");
        Book[] searchTitleList = bookManager.searchByTitle("Java");
        for(Book book : searchTitleList) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println();

        System.out.println("도서 가격 총합 : " + bookManager.getTotalPrice());
        System.out.println("도서 가격 평균 : " + bookManager.getPricaAvg());

    }

}

package com.ssafy.ws05.step3;

import java.util.Arrays;

public class BookManager {

    // singleton pattern //
    private BookManager() {}
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

    public Book[] searchByTitle(String title) {
        Book[] result;
        int countTemp=0;
        for(int i=0; i<count; i++) {
            if(books[i].getTitle().contains(title)) {
                countTemp++;
            }
        }
        result = new Book[countTemp];
        int index=0;
        for(int i=0; i<count; i++) {
            if(books[i].getTitle().contains(title)) {
                result[index] = books[i];
                index++;
            }
        }

        return result;
    }

    public Book[] getBooks() {
        Book[] books_notMagazine;
        int countTemp=0;

        for(int i=0; i<count; i++) {
            if(books[i] instanceof Magazine) {

            } else {
                countTemp++;
            }
        }

        books_notMagazine = new Book[countTemp];
        int index = 0;
        for(int i=0; i<count; i++) {
            if(books[i] instanceof Magazine) {

            } else {
                books_notMagazine[index] = books[i];
                index++;
            }
        }

        return books_notMagazine;
    }

    public Book[] getMagazine() {
        Book[] books_Magazine;
        int countTemp=0;

        for(Book book : books) {
            if(book instanceof Magazine) {
                countTemp++;
            }
        }

        books_Magazine = new Book[countTemp];
        int index = 0;
        for(Book book : books) {
            if(book instanceof Magazine) {
                books_Magazine[index] = book;
                index++;
            }
        }

        return books_Magazine;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i=0; i<count; i++) {
            totalPrice += books[i].getPrice();
        }
        return totalPrice;
    }

    public double getPricaAvg() {
        return getTotalPrice()/count;
    }
}

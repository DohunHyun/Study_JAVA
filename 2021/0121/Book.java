package com.ssafy.ws03.step3;

public class Book<setter> {
    String isbn;
    String title;
    String author;
    String publisher;
    int price;
    String desc;

    public Book() {

    }

    public Book(String isbn, String title, String author,
                String publisher, int price, String desc) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }

    public String toString() {
        return this.isbn + "  |  " + this.title + " \t|  " + this.author
                + " \t|  " + this.publisher + "\t|  " + this.price + "  |  " +
                this.desc;
    }

    //getter
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    //setter
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

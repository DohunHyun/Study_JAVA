package com.ssafy.day0427.dto;

//bnum int primary key auto_increment,
//isbn varchar(30) not null unique,
//title varchar(50),
//price int,
//description varchar(100),
//publisher varchar(30),
//author varchar(30)
public class BookDto {
	private int bnum;
	private String isbn;
	private String title;
	private int price;
	private String description;
	private String publisher;
	private String author;

///////////////////////////////////////////////////////////////////////
	public BookDto() {}
	
	public BookDto(int bnum, String isbn, String title, int price, String description, String publisher,
			String author) {
		this.bnum = bnum;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.description = description;
		this.publisher = publisher;
		this.author = author;
	}
	
	public BookDto(String isbn, String title, int price, String description, String publisher,
			String author) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.description = description;
		this.publisher = publisher;
		this.author = author;
	}
////////////////////////////////////////////////////////////////////////	
	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDto [bnum=" + bnum + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", description="
				+ description + ", publisher=" + publisher + ", author=" + author + "]";
	}

}
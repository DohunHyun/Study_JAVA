package com.hw.day0427.dto;

public class ProductDto {
	String serialnum;
	String title;
	int price;
	String description;
	
	
	public ProductDto() {
	}
	public ProductDto(String serialnum, String title, int price, String description) {
		super();
		this.serialnum = serialnum;
		this.title = title;
		this.price = price;
		this.description = description;
	}
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
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
	
	

}

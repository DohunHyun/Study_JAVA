package com.ssafy.day0428.dto;

public class ProductDto {

	String pcode;
	String pname;
	int pquantity;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public ProductDto(String pcode, String pname, int pquantity) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.pquantity = pquantity;
	}
	public ProductDto() {
		super();
	}
	
	
}

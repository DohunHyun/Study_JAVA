package com.ssafy.day0428.dto;

public class MemberDto {
	String mid;
	String mpass;
	String mname;
	public MemberDto() {
		super();
	}
	public MemberDto(String mid, String mpass, String mname) {
		super();
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpass=" + mpass + ", mname=" + mname + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
}

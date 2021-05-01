package com.day0430.board.model;

public class MemberDto {
	private String mid;
	private String mpass;
	private String mname;

	public MemberDto() {
	}

	public MemberDto(String mid, String mpass, String mname) {
		this.mid = mid;
		this.mpass = mpass;
		this.mname = mname;
	}

	public String getId() {
		return mid;
	}

	public void setId(String mid) {
		this.mid = mid;
	}

	public String getPass() {
		return mpass;
	}

	public void setPass(String mpass) {
		this.mpass = mpass;
	}

	public String getName() {
		return mname;
	}

	public void setName(String mname) {
		this.mname = mname;
	}
}

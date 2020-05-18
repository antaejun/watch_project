package com.kitchen.domain;

public class Myinfo {
	
	private Integer idx;
	private String user_pw;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	@Override
	public String toString() {
		return "Myinfo [idx=" + idx + ", user_pw=" + user_pw + "]";
	}

}

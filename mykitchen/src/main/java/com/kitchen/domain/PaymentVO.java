package com.kitchen.domain;

import java.security.Timestamp;

public class PaymentVO {

	private int idx;
	
	private String user_email;
	
	private String kichen_code;
	private String payment_status;
	private Timestamp regist_date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getKichen_code() {
		return kichen_code;
	}
	public void setKichen_code(String kichen_code) {
		this.kichen_code = kichen_code;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public Timestamp getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Timestamp regist_date) {
		this.regist_date = regist_date;
	}
	@Override
	public String toString() {
		return "PaymentVO [idx=" + idx + ", user_email=" + user_email + ", kichen_code=" + kichen_code
				+ ", payment_status=" + payment_status + ", regist_date=" + regist_date + "]";
	}
	
	
	
}

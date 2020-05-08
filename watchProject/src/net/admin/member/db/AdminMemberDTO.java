package net.admin.member.db;

import java.sql.Timestamp;

public class AdminMemberDTO {
	
	private int idx;
	private String user_email;
	private String user_pw;
	private String user_name;
	private String address;
	private String address_detail;
	private String phone;
	private Timestamp regist_date;
	private Timestamp modify_date;
	private String delete_yn;
	private String user_status;
	
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
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Timestamp regist_date) {
		this.regist_date = regist_date;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", address=" + address + ", address_detail=" + address_detail + ", phone=" + phone
				+ ", regist_date=" + regist_date + ", modify_date=" + modify_date + ", delete_yn=" + delete_yn
				+ ", user_status=" + user_status + "]";
	}
	
}

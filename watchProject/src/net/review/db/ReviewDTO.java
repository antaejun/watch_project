package net.review.db;

import java.sql.Date;

public class ReviewDTO {
	private int review_num;
	private String content;
	private String item_code;
	private String user_email;
	private Date regist_date;
	private Date modify_date;
	private String delete_yn;
	private int result;
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	
	@Override
	public String toString() {
		return "ReviewDTO [review_num=" + review_num + ", content=" + content + ", item_code=" + item_code
				+ ", user_email=" + user_email + ", regist_date=" + regist_date + ", modify_date=" + modify_date
				+ ", delete_yn=" + delete_yn + "]";
	}
	
	
	
}

package com.kitchen.domain;

import java.security.Timestamp;

public class KitchenVO {
   private Integer idx;
  
private String kitchen_name;
   private String content;
   private String region;
   private String acreage;
   private String image;
   private String thumb_image;
   private String reservation_status;
   private String kitchen_option;
   private String branch_name;
   private int rental_price;
   private String user_email;
   private Timestamp regist_date;
   private Timestamp modify_date;
   
   public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getKitchen_name() {
		return kitchen_name;
	}
	public void setKitchen_name(String kitchen_name) {
		this.kitchen_name = kitchen_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAcreage() {
		return acreage;
	}
	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getThumb_image() {
		return thumb_image;
	}
	public void setThumb_image(String thumb_image) {
		this.thumb_image = thumb_image;
	}
	public String getReservation_status() {
		return reservation_status;
	}
	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}
	public String getKitchen_option() {
		return kitchen_option;
	}
	public void setKitchen_option(String kitchen_option) {
		this.kitchen_option = kitchen_option;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public int getRental_price() {
		return rental_price;
	}
	public void setRental_price(int rental_price) {
		this.rental_price = rental_price;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
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
	@Override
	public String toString() {
		return "KitchenVO [idx=" + idx + ", kitchen_name=" + kitchen_name + ", content=" + content + ", region="
				+ region + ", acreage=" + acreage + ", image=" + image + ", thumb_image=" + thumb_image
				+ ", reservation_status=" + reservation_status + ", kitchen_option=" + kitchen_option + ", branch_name="
				+ branch_name + ", rental_price=" + rental_price + ", user_email=" + user_email + ", regist_date="
				+ regist_date + ", modify_date=" + modify_date + "]";
	}
	
	
	
}
   
  
   
   
  
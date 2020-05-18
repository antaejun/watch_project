package com.kitchen.domain;

import java.security.Timestamp;

public class RentalVO {

	 	private Integer idx;
	 	
		private String kitchen_rental_code;
	    private Timestamp R_regist_date;
	    private Timestamp R_regist_time;
	    private String user_email;
	    private String kitchen_name;
	    private Integer rental_price;
	    private String payment_type;
	    private String trade_payer;

	
	    public Integer getIdx() {
			return idx;
		}
		public void setIdx(Integer idx) {
			this.idx = idx;
		}
		public String getKitchen_rental_code() {
			return kitchen_rental_code;
		}
		public void setKitchen_rental_code(String kitchen_rental_code) {
			this.kitchen_rental_code = kitchen_rental_code;
		}
		public Timestamp getR_regist_date() {
			return R_regist_date;
		}
		public void setR_regist_date(Timestamp r_regist_date) {
			R_regist_date = r_regist_date;
		}
		public Timestamp getR_regist_time() {
			return R_regist_time;
		}
		public void setR_regist_time(Timestamp r_regist_time) {
			R_regist_time = r_regist_time;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getKitchen_name() {
			return kitchen_name;
		}
		public void setKitchen_name(String kitchen_name) {
			this.kitchen_name = kitchen_name;
		}
		public Integer getRental_price() {
			return rental_price;
		}
		public void setRental_price(Integer rental_price) {
			this.rental_price = rental_price;
		}
		public String getPayment_type() {
			return payment_type;
		}
		public void setPayment_type(String payment_type) {
			this.payment_type = payment_type;
		}
		public String getTrade_payer() {
			return trade_payer;
		}
		public void setTrade_payer(String trade_payer) {
			this.trade_payer = trade_payer;
		}
		
		
		@Override
		public String toString() {
			return "RentalVO [idx=" + idx + ", kitchen_rental_code=" + kitchen_rental_code + ", R_regist_date="
					+ R_regist_date + ", R_regist_time=" + R_regist_time + ", user_email=" + user_email
					+ ", kitchen_name=" + kitchen_name + ", rental_price=" + rental_price + ", payment_type="
					+ payment_type + ", trade_payer=" + trade_payer + "]";
		}
		
		
	
	
	
}

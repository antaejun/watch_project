package com.kitchen.domain;

	import java.sql.Date;

	public class UserVO {
		
		private Integer idx;
		private String user_email;
		private String user_pw;
		private String user_name;
		private String nick;
		private String phone;
		private String region;
		private Date regist_date;
		private Date modify_date;
		private String delete_yn;
		private String business_yn;
		private String user_status;
		
		
		
		public Integer getIdx() {
			return idx;
		}
		public void setIdx(Integer idx) {
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
		public String getNick() {
			return nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
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
		public String getBusiness_yn() {
			return business_yn;
		}
		public void setBusiness_yn(String business_yn) {
			this.business_yn = business_yn;
		}
		public String getUser_status() {
			return user_status;
		}
		public void setUser_status(String user_status) {
			this.user_status = user_status;
		}
		
	
		@Override
		public String toString() {
			return "UserVO [idx=" + idx + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_name=" + user_name
					+ ", nick=" + nick + ", phone=" + phone + ", region=" + region + ", regist_date=" + regist_date
					+ ", modify_date=" + modify_date + ", delete_yn=" + delete_yn + ", business_yn=" + business_yn
					+ ", user_status=" + user_status + "]";
		}

		
}

	


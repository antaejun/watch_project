package net.items.db;

import java.sql.Date;

public class ItemDTO {
	
	private int idx;
	private String item_code;
	private String item_name;
	private int item_price;
	private String item_color;
	private String item_size;
	private int item_amount;
	private String code;
	private String code_detail;
	private String item_info;
	private Date regist_date;
	private String delete_yn;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_color() {
		return item_color;
	}
	public void setItem_color(String item_color) {
		this.item_color = item_color;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_detail() {
		return code_detail;
	}
	public void setCode_detail(String code_detail) {
		this.code_detail = code_detail;
	}
	public String getItem_info() {
		return item_info;
	}
	public void setItem_info(String item_info) {
		this.item_info = item_info;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	
	@Override
	public String toString() {
		return "ItemDTO [idx=" + idx + ", item_code=" + item_code + ", item_name=" + item_name + ", item_price="
				+ item_price + ", item_color=" + item_color + ", item_size=" + item_size + ", item_amount="
				+ item_amount + ", code=" + code + ", code_detail=" + code_detail + ", item_info=" + item_info
				+ ", regist_date=" + regist_date + ", delete_yn=" + delete_yn + "]";
	}
	
}

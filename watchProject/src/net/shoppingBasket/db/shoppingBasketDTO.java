package net.shoppingBasket.db;



public class shoppingBasketDTO {

	private int idx;
	private String item_code;
	private int basket_amount;
	private int basket_price;
	private String basket_color;
	private String basket_size;
	private String user_email;
	
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
	public int getBasket_amount() {
		return basket_amount;
	}
	public void setBasket_amount(int basket_amount) {
		this.basket_amount = basket_amount;
	}
	public int getBasket_price() {
		return basket_price;
	}
	public void setBasket_price(int basket_price) {
		this.basket_price = basket_price;
	}
	public String getBasket_color() {
		return basket_color;
	}
	public void setBasket_color(String basket_color) {
		this.basket_color = basket_color;
	}
	public String getBasket_size() {
		return basket_size;
	}
	public void setBasket_size(String basket_size) {
		this.basket_size = basket_size;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	@Override
	public String toString() {
		return "shoppingBasketDTO [idx=" + idx + ", item_code=" + item_code + ", basket_amount=" + basket_amount
				+ ", basket_price=" + basket_price + ", basket_color=" + basket_color + ", basket_size=" + basket_size
				+ ", user_email=" + user_email + "]";
	}
	

}

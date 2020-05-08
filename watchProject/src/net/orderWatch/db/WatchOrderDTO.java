package net.orderWatch.db;


import java.sql.Date;
import java.sql.Timestamp;

public class WatchOrderDTO {
	

	private int idx;
	private String order_code;
	private String item_code;
	private String order_status;
	private Timestamp order_date;
	private int order_amount;
	private String order_name;
	private String order_phone;
	private String receive_name;
	private String receive_phone;
	private String receive_address;
	private String receive_adress_detail;
	private String memo;
	private int order_price;
	private String order_color;
	private String order_size;
	private String payment_type;
	private String trade_payer;
	private Date payment_date;
	private String user_email;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getReceive_phone() {
		return receive_phone;
	}
	public void setReceive_phone(String receive_phone) {
		this.receive_phone = receive_phone;
	}
	public String getReceive_address() {
		return receive_address;
	}
	public void setReceive_address(String receive_address) {
		this.receive_address = receive_address;
	}
	public String getReceive_adress_detail() {
		return receive_adress_detail;
	}
	public void setReceive_adress_detail(String receive_adress_detail) {
		this.receive_adress_detail = receive_adress_detail;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_color() {
		return order_color;
	}
	public void setOrder_color(String order_color) {
		this.order_color = order_color;
	}
	public String getOrder_size() {
		return order_size;
	}
	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	@Override
	public String toString() {
		return "WatchOrderDTO [idx=" + idx + ", order_code=" + order_code + ", item_code=" + item_code
				+ ", order_status=" + order_status + ", order_date=" + order_date + ", order_amount=" + order_amount
				+ ", order_name=" + order_name + ", order_phone=" + order_phone + ", receive_name=" + receive_name
				+ ", receive_phone=" + receive_phone + ", receive_address=" + receive_address
				+ ", receive_adress_detail=" + receive_adress_detail + ", memo=" + memo + ", order_price=" + order_price
				+ ", order_color=" + order_color + ", order_size=" + order_size + ", payment_date=" + payment_date
				+ ", payment_type=" + payment_type + ", trade_payer=" + trade_payer + ",user_email=" + user_email + "]";
	}
	
	
	
	
	

}

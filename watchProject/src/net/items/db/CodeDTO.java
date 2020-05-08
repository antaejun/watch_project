package net.items.db;

import java.sql.Date;

public class CodeDTO {
	
	private int idx;
	private String code;
	private String code_name;
	private Date regist_date;
	private String delete_yn;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
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
		return "codeDTO [idx=" + idx + ", code=" + code + ", code_name=" + code_name + ", regist_date=" + regist_date
				+ ", delete_yn=" + delete_yn + "]";
	}
	
	
	
	

}

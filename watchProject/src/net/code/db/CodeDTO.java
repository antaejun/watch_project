package net.code.db;

import java.sql.Timestamp;

public class CodeDTO {
	
	private int idx;
	private int code;
	private String code_name;
	private Timestamp regist_date;
	private String delete_yn;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public Timestamp getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Timestamp regist_date) {
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
		return "CodeDTO [idx=" + idx + ", code=" + code + ", code_name=" + code_name + ", regist_date=" + regist_date
				+ ", delete_yn=" + delete_yn + "]";
	}
	
}

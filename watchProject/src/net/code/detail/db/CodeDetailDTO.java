package net.code.detail.db;

import java.sql.Date;
import java.sql.Timestamp;

public class CodeDetailDTO {
	
	private int idx;
	private String code_detail;
	private String code_detail_name;
	private int code;
	private Timestamp regist_date;
	private String delete_yn;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCode_detail() {
		return code_detail;
	}
	public void setCode_detail(String code_detail) {
		this.code_detail = code_detail;
	}
	public String getCode_detail_name() {
		return code_detail_name;
	}
	public void setCode_detail_name(String code_detail_name) {
		this.code_detail_name = code_detail_name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
		return "CodeDetailDTO [idx=" + idx + ", code_detail=" + code_detail + ", code_detail_name=" + code_detail_name
				+ ", code=" + code + ", regist_date=" + regist_date + ", delete_yn=" + delete_yn + "]";
	}
	
	
	
	
	
}

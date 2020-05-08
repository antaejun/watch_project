package net.items.db;

import java.sql.Date;

public class CodeDetailDTO {
	
	private int idx;
	private String code_detail;
	private String code_detail_name;
	private String code;
	private Date regist_date;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
		return "codeDetailDTO [idx=" + idx + ", code_detail=" + code_detail + ", code_detail_name=" + code_detail_name
				+ ", code=" + code + ", regist_date=" + regist_date + ", delete_yn=" + delete_yn + "]";
	}
	
	
	
	
	

}

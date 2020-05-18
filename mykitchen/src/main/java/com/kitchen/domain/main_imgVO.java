package com.kitchen.domain;

import java.security.Timestamp;

public class main_imgVO {
	
	private String img_path;
    private String img_file;
    private String height;
    private String width;
    private String link;
    private Integer idx;
	 private Integer order;
	  
	 public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getImg_file() {
		return img_file;
	}
	public void setImg_file(String img_file) {
		this.img_file = img_file;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "main_imgVO [img_path=" + img_path + ", img_file=" + img_file + ", height=" + height + ", width=" + width
				+ ", link=" + link + ", idx=" + idx + ", order=" + order + "]";
	}
	
	
}

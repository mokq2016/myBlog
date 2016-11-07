package com.java1234.entity;

public class BlogType {
	private int id;
	private String typeName;
	private int orderNo;
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNo="
				+ orderNo + ", desc=" + desc + "]";
	}

	
}

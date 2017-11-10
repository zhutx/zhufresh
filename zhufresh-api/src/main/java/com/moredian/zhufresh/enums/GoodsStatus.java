package com.moredian.zhufresh.enums;

public enum GoodsStatus {

	DISABLE("禁用", 0),
	ENABLE("可用", 1),
	DELETE("删除", 2)

	;
	
	private String desc;
	private int value;
	
	GoodsStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(GoodsStatus item : GoodsStatus.values()) {
			if (item.getValue() == value) {
				return item.desc;
			}
		}
		return null;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

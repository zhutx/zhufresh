package com.moredian.zhufresh.enums;

public enum GoodsUnit {
	
	JIN("斤", 1),
	PING("瓶", 2)
	
	;
	
	private String desc;
	private int value;
	
	GoodsUnit(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(GoodsUnit item : GoodsUnit.values()) {
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

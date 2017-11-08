package com.moredian.zhufresh.enums;

public enum OrderType {
	
	MARKET("菜场", 1),
	PRESALE("预售", 2),
	SUPPLY("特供", 3),
	HOTPOT("火锅", 4)
	
	;
	
	private String desc;
	private int value;
	
	OrderType(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(OrderType item : OrderType.values()) {
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

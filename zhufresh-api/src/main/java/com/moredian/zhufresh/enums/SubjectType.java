package com.moredian.zhufresh.enums;

public enum SubjectType {
	
	SUPPLY("预售", 1),
	PRESALE("特供", 2),
	HOTPOT("火锅", 3),
	ACTIVITY("活动", 4),
	
	;
	
	private String desc;
	private int value;
	
	SubjectType(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(SubjectType item : SubjectType.values()) {
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

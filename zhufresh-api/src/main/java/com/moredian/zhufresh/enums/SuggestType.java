package com.moredian.zhufresh.enums;

public enum SuggestType {
	
	COMPLAINTS("投诉", 1),
	SUGGEST("建议", 2),
	
	;
	
	private String desc;
	private int value;
	
	SuggestType(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(SuggestType item : SuggestType.values()) {
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

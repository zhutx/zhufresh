package com.moredian.zhufresh.enums;

public enum RefundType {
	
	WHOLE("整单退款", 1),
	DIFF("差价退款", 2),
	
	;
	
	private String desc;
	private int value;
	
	RefundType(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(RefundType item : RefundType.values()) {
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

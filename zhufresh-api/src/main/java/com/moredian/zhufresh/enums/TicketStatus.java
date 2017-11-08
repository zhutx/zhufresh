package com.moredian.zhufresh.enums;

public enum TicketStatus {
	
	UNUSED("未使用", 1),
	USED("已使用", 2),
	EXPIRE("已过期", 3),
	
	;
	
	private String desc;
	private int value;
	
	TicketStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(TicketStatus item : TicketStatus.values()) {
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

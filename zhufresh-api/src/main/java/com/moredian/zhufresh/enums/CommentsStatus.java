package com.moredian.zhufresh.enums;

public enum CommentsStatus {
	
	ENABLE("有效", 1),
	DISABLE("无效", 0),
	
	;
	
	private String desc;
	private int value;
	
	CommentsStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(CommentsStatus item : CommentsStatus.values()) {
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

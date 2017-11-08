package com.moredian.zhufresh.enums;

public enum SubjectStatus {
	
	UNBEGIN("未开始", 0),
	DOING("进行中", 1),
	FINISH("已结束", 2),
	
	;
	
	private String desc;
	private int value;
	
	SubjectStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(SubjectStatus item : SubjectStatus.values()) {
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

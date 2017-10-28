package com.moredian.tuna.certification.enums;

public enum PersonNature {
	
	HAN("汉",1),
	
	HUI("回",2),
	
	;
	
	private String desc;
	
	private int value;

	PersonNature(String desc ,int value){
		this.value = value;
		this.desc =desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public static String getDesc(int value) {
		for (PersonNature type : PersonNature.values()) {
			if (type.getValue() == value) {
				return type.desc;
			}
		}
		return null;
	}
	
	public static int getValue(String desc) {
		for (PersonNature type : PersonNature.values()) {
			if (type.getDesc().equals(desc)) {
				return type.getValue();
			}
		}
		return 0;
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

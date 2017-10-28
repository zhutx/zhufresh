package com.moredian.tuna.certification.enums;

public enum PersonSex {
	
	MALE("男",1),
	
	FEMALE("女",2),
	
	;
	
	private String desc;
	
	private int value;

	PersonSex(String desc ,int value){
		this.value = value;
		this.desc =desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public static String getDesc(int value) {
		for (PersonSex type : PersonSex.values()) {
			if (type.getValue() == value) {
				return type.desc;
			}
		}
		return null;
	}
	
	public static int getValue(String desc) {
		for (PersonSex type : PersonSex.values()) {
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

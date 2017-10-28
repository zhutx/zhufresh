package com.moredian.tuna.certification.enums;

public enum AuthStatus {
	
	FAIL("认证失败",0),
	
	SUCC("认证成功",1),
	
	;
	
	private String desc;
	
	private int value;

	AuthStatus(String desc ,int value){
		this.value = value;
		this.desc =desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public static String getDesc(int value) {
		for (AuthStatus type : AuthStatus.values()) {
			if (type.getValue() == value) {
				return type.desc;
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

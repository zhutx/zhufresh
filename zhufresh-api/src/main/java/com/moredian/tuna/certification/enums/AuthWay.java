package com.moredian.tuna.certification.enums;

public enum AuthWay {
	
	FACE_MATCH("人脸身份对比",1),
	
	ZHIFUBAO("支付宝认证",2),
	
	CERT_NO("手输身份证",3),
	
	;
	
	private String desc;
	
	private int value;

	AuthWay(String desc ,int value){
		this.value = value;
		this.desc =desc;
	}
	
	public String getDesc() {
		return desc;
	}

	public static String getDesc(int value) {
		for (AuthWay type : AuthWay.values()) {
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

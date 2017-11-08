package com.moredian.zhufresh.enums;

public enum PayWay {
	
	ALIPAY("支付宝", 1),
	WECHAT("微信", 2),
	
	;
	
	private String desc;
	private int value;
	
	PayWay(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(PayWay item : PayWay.values()) {
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

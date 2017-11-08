package com.moredian.zhufresh.enums;

public enum OrderStatus {
	
	NEW("新订单（未支付）", 0),
	PAY("已支付（待采购）", 1),
	IN_PUR("采购中", 2),
	OVER_PUR("已采购", 3),
	WAIT_DELI("待配送（已保鲜备货）", 4),
	IN_DELI("配送中", 5),
	FINISH("已完成", 6),
	
	;
	
	private String desc;
	private int value;
	
	OrderStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(OrderStatus item : OrderStatus.values()) {
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

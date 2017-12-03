package com.moredian.zhufresh.enums;

public enum CartGoodsStatus {

	UP("上架中", 1),
	DOWN("已下架", 0),

	;

	private String desc;
	private int value;

	CartGoodsStatus(String desc, int value) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static String getDesc(int value) {
		for(CartGoodsStatus item : CartGoodsStatus.values()) {
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

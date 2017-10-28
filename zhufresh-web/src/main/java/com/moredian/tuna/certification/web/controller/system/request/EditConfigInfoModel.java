package com.moredian.tuna.certification.web.controller.system.request;

public class EditConfigInfoModel {
	
	private Integer areaCode;
	private String contact;
	private String phone;
	private Integer hotels;
	private Integer bars;
	
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getHotels() {
		return hotels;
	}
	public void setHotels(Integer hotels) {
		this.hotels = hotels;
	}
	public Integer getBars() {
		return bars;
	}
	public void setBars(Integer bars) {
		this.bars = bars;
	}

}

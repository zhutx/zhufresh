package com.moredian.tuna.certification.web.controller.zone.response;

public class AreaAuthCollData {
	
	private Integer areaCode;
	private String areaName;
	private String contact;
	private String phone;
	private Integer hotels;
	private Integer hotelInstalls;
	private Integer nets;
	private Integer netInstalls;
	private Integer authTimes;
	private Integer failTimes;
	private Integer deviceOnLines;
	
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	public Integer getHotelInstalls() {
		return hotelInstalls;
	}
	public void setHotelInstalls(Integer hotelInstalls) {
		this.hotelInstalls = hotelInstalls;
	}
	public Integer getNets() {
		return nets;
	}
	public void setNets(Integer nets) {
		this.nets = nets;
	}
	public Integer getNetInstalls() {
		return netInstalls;
	}
	public void setNetInstalls(Integer netInstalls) {
		this.netInstalls = netInstalls;
	}
	public Integer getAuthTimes() {
		return authTimes;
	}
	public void setAuthTimes(Integer authTimes) {
		this.authTimes = authTimes;
	}
	public Integer getFailTimes() {
		return failTimes;
	}
	public void setFailTimes(Integer failTimes) {
		this.failTimes = failTimes;
	}
	public Integer getDeviceOnLines() {
		return deviceOnLines;
	}
	public void setDeviceOnLines(Integer deviceOnLines) {
		this.deviceOnLines = deviceOnLines;
	}

}

package com.moredian.tuna.certification.web.controller.system.response;

import java.util.ArrayList;
import java.util.List;

public class ConfigInfoData {
	
	private Integer areaCode;
	private String areaName;
	private String contact;
	private String phone;
	private Integer hotels;
	private Integer bars;
	
	private List<ConfigInfoData> children = new ArrayList<>();

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

	public Integer getBars() {
		return bars;
	}

	public void setBars(Integer bars) {
		this.bars = bars;
	}

	public List<ConfigInfoData> getChildren() {
		return children;
	}

	public void setChildren(List<ConfigInfoData> children) {
		this.children = children;
	}
	
	

}

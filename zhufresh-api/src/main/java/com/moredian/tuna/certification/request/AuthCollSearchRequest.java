package com.moredian.tuna.certification.request;

import java.io.Serializable;

public class AuthCollSearchRequest implements Serializable {
	
	private static final long serialVersionUID = 430462265652621030L;
	
	private Integer provCode;
	private Integer cityCode;
	private Integer districtCode;
	private Integer townCode;
	private Integer onlineFlag;
	private String orgName;
	
	public Integer getProvCode() {
		return provCode;
	}
	public void setProvCode(Integer provCode) {
		this.provCode = provCode;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}
	public Integer getTownCode() {
		return townCode;
	}
	public void setTownCode(Integer townCode) {
		this.townCode = townCode;
	}
	public Integer getOnlineFlag() {
		return onlineFlag;
	}
	public void setOnlineFlag(Integer onlineFlag) {
		this.onlineFlag = onlineFlag;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}

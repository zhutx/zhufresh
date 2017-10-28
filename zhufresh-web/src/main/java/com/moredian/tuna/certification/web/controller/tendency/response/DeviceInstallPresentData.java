package com.moredian.tuna.certification.web.controller.tendency.response;

public class DeviceInstallPresentData {
	
	private Integer areaCode;
	private String areaName;
	private Integer totals;
	private Integer installs;
	
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
	public Integer getTotals() {
		return totals;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public Integer getInstalls() {
		return installs;
	}
	public void setInstalls(Integer installs) {
		this.installs = installs;
	}

}

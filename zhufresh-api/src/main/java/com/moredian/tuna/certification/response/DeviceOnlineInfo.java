package com.moredian.tuna.certification.response;

import java.io.Serializable;

public class DeviceOnlineInfo implements Serializable {
	
	private static final long serialVersionUID = 8390923010108980336L;
	
	private Long deviceId;
	private Integer orgType;
	private Integer onlineFlag;
	
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	public Integer getOnlineFlag() {
		return onlineFlag;
	}
	public void setOnlineFlag(Integer onlineFlag) {
		this.onlineFlag = onlineFlag;
	}

}

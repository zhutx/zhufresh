package com.moredian.tuna.certification.domain;

import java.util.Date;

public class PrivateCloud {
	
	private Long privateCloudId;
	private Integer areaLevel;
	private Integer areaCode;
	private String alarmWebUrl;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getPrivateCloudId() {
		return privateCloudId;
	}
	public void setPrivateCloudId(Long privateCloudId) {
		this.privateCloudId = privateCloudId;
	}
	public Integer getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}
	public Integer getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}
	public String getAlarmWebUrl() {
		return alarmWebUrl;
	}
	public void setAlarmWebUrl(String alarmWebUrl) {
		this.alarmWebUrl = alarmWebUrl;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

}

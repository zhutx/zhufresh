package com.moredian.tuna.certification.model;

import java.io.Serializable;
import java.util.Date;

public class AuthDistInfo implements Serializable {
	
	private static final long serialVersionUID = 3237242630148190961L;
	
	private Long id;
	private Integer areaCode;
	private String areaName;
	private Integer orgType;
	private Integer authTimes;
	private Integer failTimes;
	private Integer alarmTimes;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
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
	public Integer getAlarmTimes() {
		return alarmTimes;
	}
	public void setAlarmTimes(Integer alarmTimes) {
		this.alarmTimes = alarmTimes;
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
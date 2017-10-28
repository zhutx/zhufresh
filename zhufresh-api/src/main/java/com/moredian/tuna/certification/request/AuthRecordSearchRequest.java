package com.moredian.tuna.certification.request;

import java.io.Serializable;
import java.util.Date;

public class AuthRecordSearchRequest implements Serializable {
	
	private static final long serialVersionUID = 4266262641437976059L;
	
	private Integer provCode;
	private Integer cityCode;
	private Integer districtCode;
	private Integer townCode;
	private Integer orgType;
	private Integer status;
	private Integer authWay;
	private String certNo;
	private Integer triggerAlarmFlag;
	private Date beginDate;
	private Date endDate;
	private String orgName;
	private Long deviceId;
	
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
	public Integer getOrgType() {
		return orgType;
	}
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAuthWay() {
		return authWay;
	}
	public void setAuthWay(Integer authWay) {
		this.authWay = authWay;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public Integer getTriggerAlarmFlag() {
		return triggerAlarmFlag;
	}
	public void setTriggerAlarmFlag(Integer triggerAlarmFlag) {
		this.triggerAlarmFlag = triggerAlarmFlag;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

}

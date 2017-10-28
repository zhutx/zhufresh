package com.moredian.tuna.certification.web.controller.auth.response;

import java.util.Date;

public class AuthResponse {
	
	private String catchImageUrl;
	private String matchImageUrl;
	private Long authTime;
	private Float quality;
	private Float confidence;
	private String realName;
	private Integer sex;
	private Integer nature;
	private String birthday;
	private String address;
	private String certNo;
	private String signOrg;
	private String validBeginDate;
	private String validEndDate;
	private Integer status;
	
	public String getCatchImageUrl() {
		return catchImageUrl;
	}
	public void setCatchImageUrl(String catchImageUrl) {
		this.catchImageUrl = catchImageUrl;
	}
	public String getMatchImageUrl() {
		return matchImageUrl;
	}
	public void setMatchImageUrl(String matchImageUrl) {
		this.matchImageUrl = matchImageUrl;
	}
	public Long getAuthTime() {
		return authTime;
	}
	public void setAuthTime(Long authTime) {
		this.authTime = authTime;
	}
	public Float getQuality() {
		return quality;
	}
	public void setQuality(Float quality) {
		this.quality = quality;
	}
	public Float getConfidence() {
		return confidence;
	}
	public void setConfidence(Float confidence) {
		this.confidence = confidence;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getNature() {
		return nature;
	}
	public void setNature(Integer nature) {
		this.nature = nature;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getSignOrg() {
		return signOrg;
	}
	public void setSignOrg(String signOrg) {
		this.signOrg = signOrg;
	}
	public String getValidBeginDate() {
		return validBeginDate;
	}
	public void setValidBeginDate(String validBeginDate) {
		this.validBeginDate = validBeginDate;
	}
	public String getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(String validEndDate) {
		this.validEndDate = validEndDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}

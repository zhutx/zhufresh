package com.moredian.tuna.certification.response;

import java.io.Serializable;

public class AuthTopInfo implements Serializable {
	
	private static final long serialVersionUID = -2375788097785753280L;
	
	private Long orgId;
	private String orgName;
	private Integer authTimes;
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getAuthTimes() {
		return authTimes;
	}
	public void setAuthTimes(Integer authTimes) {
		this.authTimes = authTimes;
	}

}

package com.moredian.tuna.certification.response;

import java.io.Serializable;

public class AuthFailTopInfo implements Serializable {
	
	private static final long serialVersionUID = -2375788097785753280L;
	
	private Long orgId;
	private String orgName;
	private Integer failTimes;
	
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
	public Integer getFailTimes() {
		return failTimes;
	}
	public void setFailTimes(Integer failTimes) {
		this.failTimes = failTimes;
	}

}

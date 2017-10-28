package com.moredian.tuna.certification.model;

import java.io.Serializable;
import java.util.Date;

public class DeviceDistInfo implements Serializable {
	
	private static final long serialVersionUID = 3416028281868436370L;
	
	private Long id;
	private Integer areaCode;
	private String areaName;
	private Integer orgType;
	private Integer totals;
	private Integer installs;
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

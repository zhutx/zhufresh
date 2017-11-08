package com.moredian.zhufresh.domain;

import java.util.Date;

public class OperRole {
	
	private Long operRoleId;
	private Long operId;
	private Long roleId;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getOperRoleId() {
		return operRoleId;
	}
	public void setOperRoleId(Long operRoleId) {
		this.operRoleId = operRoleId;
	}
	public Long getOperId() {
		return operId;
	}
	public void setOperId(Long operId) {
		this.operId = operId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

package com.moredian.tuna.certification.web.controller.system.request;

public class AddOperModel {
	
	private Long orgId;
	private Integer moduleType;
	private String operName;
	private String operDesc;
	private String accountName;
	private String password;
	private String mobile;
	private String email;
	private String roleIds;
	
	private Integer provAreaCode;
	private Integer cityAreaCode;
	private Integer districtAreaCode;
	private Integer townAreaCode;
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Integer getModuleType() {
		return moduleType;
	}
	public void setModuleType(Integer moduleType) {
		this.moduleType = moduleType;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getOperDesc() {
		return operDesc;
	}
	public void setOperDesc(String operDesc) {
		this.operDesc = operDesc;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getProvAreaCode() {
		return provAreaCode;
	}
	public void setProvAreaCode(Integer provAreaCode) {
		this.provAreaCode = provAreaCode;
	}
	public Integer getCityAreaCode() {
		return cityAreaCode;
	}
	public void setCityAreaCode(Integer cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}
	public Integer getDistrictAreaCode() {
		return districtAreaCode;
	}
	public void setDistrictAreaCode(Integer districtAreaCode) {
		this.districtAreaCode = districtAreaCode;
	}
	public Integer getTownAreaCode() {
		return townAreaCode;
	}
	public void setTownAreaCode(Integer townAreaCode) {
		this.townAreaCode = townAreaCode;
	}
	

}

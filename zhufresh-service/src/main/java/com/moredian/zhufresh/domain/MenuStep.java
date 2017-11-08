package com.moredian.zhufresh.domain;

import java.util.Date;

public class MenuStep {
	
	private Long menuStepId;
	private Long menuId;
	private Integer stepNumber;
	private String stepImgUrl;
	private String stepDesc;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getMenuStepId() {
		return menuStepId;
	}
	public void setMenuStepId(Long menuStepId) {
		this.menuStepId = menuStepId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Integer getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}
	public String getStepImgUrl() {
		return stepImgUrl;
	}
	public void setStepImgUrl(String stepImgUrl) {
		this.stepImgUrl = stepImgUrl;
	}
	public String getStepDesc() {
		return stepDesc;
	}
	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
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

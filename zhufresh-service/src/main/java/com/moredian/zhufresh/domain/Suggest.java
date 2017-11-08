package com.moredian.zhufresh.domain;

import java.util.Date;

public class Suggest {
	
	private Long suggestId;
	private Long userId;
	private Integer suggestType;
	private String showImgUrl;
	private String suggestDesc;
	private Integer dealFlag;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getSuggestId() {
		return suggestId;
	}
	public void setSuggestId(Long suggestId) {
		this.suggestId = suggestId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getSuggestType() {
		return suggestType;
	}
	public void setSuggestType(Integer suggestType) {
		this.suggestType = suggestType;
	}
	public String getShowImgUrl() {
		return showImgUrl;
	}
	public void setShowImgUrl(String showImgUrl) {
		this.showImgUrl = showImgUrl;
	}
	public String getSuggestDesc() {
		return suggestDesc;
	}
	public void setSuggestDesc(String suggestDesc) {
		this.suggestDesc = suggestDesc;
	}
	public Integer getDealFlag() {
		return dealFlag;
	}
	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
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

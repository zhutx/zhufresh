package com.moredian.zhufresh.domain;

import java.util.Date;

public class Oper {
	
	private Long operId;
	private String operName;
	private String mobile;
	private Integer deliveryTimes;
	private Integer gotStars;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getOperId() {
		return operId;
	}
	public void setOperId(Long operId) {
		this.operId = operId;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getDeliveryTimes() {
		return deliveryTimes;
	}
	public void setDeliveryTimes(Integer deliveryTimes) {
		this.deliveryTimes = deliveryTimes;
	}
	public Integer getGotStars() {
		return gotStars;
	}
	public void setGotStars(Integer gotStars) {
		this.gotStars = gotStars;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

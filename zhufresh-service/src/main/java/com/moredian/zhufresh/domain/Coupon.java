package com.moredian.zhufresh.domain;

import java.util.Date;

public class Coupon {
	
	private Long couponId;
	private String couponCode;
	private Integer couponPrice;
	private Long bindUserId;
	private Date bindDate;
	private Date expireDate;
	private Date useTime;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getCouponId() {
		return couponId;
	}
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Integer getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(Integer couponPrice) {
		this.couponPrice = couponPrice;
	}
	public Long getBindUserId() {
		return bindUserId;
	}
	public void setBindUserId(Long bindUserId) {
		this.bindUserId = bindUserId;
	}

	public Date getBindDate() {
		return bindDate;
	}

	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
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

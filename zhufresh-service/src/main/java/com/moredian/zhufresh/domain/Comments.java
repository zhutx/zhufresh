package com.moredian.zhufresh.domain;

public class Comments {
	
	private Long commentsId;
	private Long userId;
	private Long orderId;
	private String orderCode;
	private Integer qualityStar;
	private Integer serviceStar;
	private Integer wholeStar;
	private String commentsDesc;
	private Integer dealFlag;
	private Integer status;
	
	public Long getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(Long commentsId) {
		this.commentsId = commentsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Integer getQualityStar() {
		return qualityStar;
	}
	public void setQualityStar(Integer qualityStar) {
		this.qualityStar = qualityStar;
	}
	public Integer getServiceStar() {
		return serviceStar;
	}
	public void setServiceStar(Integer serviceStar) {
		this.serviceStar = serviceStar;
	}
	public Integer getWholeStar() {
		return wholeStar;
	}
	public void setWholeStar(Integer wholeStar) {
		this.wholeStar = wholeStar;
	}
	public String getCommentsDesc() {
		return commentsDesc;
	}
	public void setCommentsDesc(String commentsDesc) {
		this.commentsDesc = commentsDesc;
	}
	public Integer getDealFlag() {
		return dealFlag;
	}
	public void setDealFlag(Integer dealFlag) {
		this.dealFlag = dealFlag;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}

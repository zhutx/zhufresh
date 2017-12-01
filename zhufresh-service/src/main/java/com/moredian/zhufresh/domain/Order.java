package com.moredian.zhufresh.domain;

import java.util.Date;

public class Order {
	
	private Long orderId;
	private String orderCode;
	private Integer orderType;
	private Integer orderGoodsPrice;
	private Integer orderServicePrice;
	private Integer orderGoodsSize;
	private String ticketCode;
	private Integer ticketPrice;
	private String couponCode;
	private Integer couponPrice;
	private String orderMessage;
	private Integer payPrice;
	private Integer payWay;
	private Long deliveryOperId;
	private String deliveryOperName;
	private String deliveryMobile;
	private Long receiveUserId;
	private String receiveName;
	private String receiveMobile;
	private String receiveAddress;
	private Date receiveExpectBeginTime;
	private Date receiveExpectEndTime;
	private Integer needRefundFlag;
	private Integer refundType;
	private Integer overRefundFlag;
	private Date receiveRealTime;
	private Integer commentsFlag;
	private Long commentsId;
	private Long lastVisitRecordId;
	private Integer vipOrderFlag;
	private Integer takeCareFlag;
	private String takeCareDesc;
	private Integer priority;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
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
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getOrderGoodsPrice() {
		return orderGoodsPrice;
	}
	public void setOrderGoodsPrice(Integer orderGoodsPrice) {
		this.orderGoodsPrice = orderGoodsPrice;
	}
	public Integer getOrderServicePrice() {
		return orderServicePrice;
	}
	public void setOrderServicePrice(Integer orderServicePrice) {
		this.orderServicePrice = orderServicePrice;
	}
	public Integer getOrderGoodsSize() {
		return orderGoodsSize;
	}
	public void setOrderGoodsSize(Integer orderGoodsSize) {
		this.orderGoodsSize = orderGoodsSize;
	}
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
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
	public String getOrderMessage() {
		return orderMessage;
	}
	public void setOrderMessage(String orderMessage) {
		this.orderMessage = orderMessage;
	}
	public Integer getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(Integer payPrice) {
		this.payPrice = payPrice;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Long getDeliveryOperId() {
		return deliveryOperId;
	}
	public void setDeliveryOperId(Long deliveryOperId) {
		this.deliveryOperId = deliveryOperId;
	}
	public String getDeliveryOperName() {
		return deliveryOperName;
	}
	public void setDeliveryOperName(String deliveryOperName) {
		this.deliveryOperName = deliveryOperName;
	}
	public String getDeliveryMobile() {
		return deliveryMobile;
	}
	public void setDeliveryMobile(String deliveryMobile) {
		this.deliveryMobile = deliveryMobile;
	}
	public Long getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(Long receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getReceiveMobile() {
		return receiveMobile;
	}
	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public Date getReceiveExpectBeginTime() {
		return receiveExpectBeginTime;
	}

	public void setReceiveExpectBeginTime(Date receiveExpectBeginTime) {
		this.receiveExpectBeginTime = receiveExpectBeginTime;
	}

	public Date getReceiveExpectEndTime() {
		return receiveExpectEndTime;
	}

	public void setReceiveExpectEndTime(Date receiveExpectEndTime) {
		this.receiveExpectEndTime = receiveExpectEndTime;
	}

	public Integer getNeedRefundFlag() {
		return needRefundFlag;
	}
	public void setNeedRefundFlag(Integer needRefundFlag) {
		this.needRefundFlag = needRefundFlag;
	}
	public Integer getRefundType() {
		return refundType;
	}
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}
	public Integer getOverRefundFlag() {
		return overRefundFlag;
	}
	public void setOverRefundFlag(Integer overRefundFlag) {
		this.overRefundFlag = overRefundFlag;
	}
	public Date getReceiveRealTime() {
		return receiveRealTime;
	}
	public void setReceiveRealTime(Date receiveRealTime) {
		this.receiveRealTime = receiveRealTime;
	}
	public Integer getCommentsFlag() {
		return commentsFlag;
	}
	public void setCommentsFlag(Integer commentsFlag) {
		this.commentsFlag = commentsFlag;
	}
	public Long getCommentsId() {
		return commentsId;
	}
	public void setCommentsId(Long commentsId) {
		this.commentsId = commentsId;
	}
	public Long getLastVisitRecordId() {
		return lastVisitRecordId;
	}
	public void setLastVisitRecordId(Long lastVisitRecordId) {
		this.lastVisitRecordId = lastVisitRecordId;
	}
	public Integer getVipOrderFlag() {
		return vipOrderFlag;
	}
	public void setVipOrderFlag(Integer vipOrderFlag) {
		this.vipOrderFlag = vipOrderFlag;
	}
	public Integer getTakeCareFlag() {
		return takeCareFlag;
	}
	public void setTakeCareFlag(Integer takeCareFlag) {
		this.takeCareFlag = takeCareFlag;
	}
	public String getTakeCareDesc() {
		return takeCareDesc;
	}
	public void setTakeCareDesc(String takeCareDesc) {
		this.takeCareDesc = takeCareDesc;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
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

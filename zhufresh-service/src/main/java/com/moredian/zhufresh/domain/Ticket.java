package com.moredian.zhufresh.domain;

import java.util.Date;

public class Ticket {
	
	private Long ticketId;
	private String ticketCode;
	private Integer ticketPrice;
	private Long dispatchOperId;
	private String dispatchOperName;
	private Long bindUserId;
	private Integer longTimeFlag;
	private Date expireDate;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	public Integer getLongTimeFlag() {
		return longTimeFlag;
	}
	public void setLongTimeFlag(Integer longTimeFlag) {
		this.longTimeFlag = longTimeFlag;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public Long getDispatchOperId() {
		return dispatchOperId;
	}
	public void setDispatchOperId(Long dispatchOperId) {
		this.dispatchOperId = dispatchOperId;
	}
	public String getDispatchOperName() {
		return dispatchOperName;
	}
	public void setDispatchOperName(String dispatchOperName) {
		this.dispatchOperName = dispatchOperName;
	}
	public Long getBindUserId() {
		return bindUserId;
	}
	public void setBindUserId(Long bindUserId) {
		this.bindUserId = bindUserId;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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

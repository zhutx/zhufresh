package com.moredian.zhufresh.domain;

import java.util.Date;

public class PurchaseItem {
	
	private Long purchaseItemId;
	private String purchaseItemCode;
	private Long purchaseId;
	private String purchaseCode;
	private Integer goodsType1;
	private Long purchaseOperId;
	private String purchaseOperName;
	private Date setoutTime;
	private Date doingTime;
	private Date finishTime;
	private Date arrivalTime;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getPurchaseItemId() {
		return purchaseItemId;
	}
	public void setPurchaseItemId(Long purchaseItemId) {
		this.purchaseItemId = purchaseItemId;
	}
	public String getPurchaseItemCode() {
		return purchaseItemCode;
	}
	public void setPurchaseItemCode(String purchaseItemCode) {
		this.purchaseItemCode = purchaseItemCode;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public Integer getGoodsType1() {
		return goodsType1;
	}
	public void setGoodsType1(Integer goodsType1) {
		this.goodsType1 = goodsType1;
	}
	public Long getPurchaseOperId() {
		return purchaseOperId;
	}
	public void setPurchaseOperId(Long purchaseOperId) {
		this.purchaseOperId = purchaseOperId;
	}
	public String getPurchaseOperName() {
		return purchaseOperName;
	}
	public void setPurchaseOperName(String purchaseOperName) {
		this.purchaseOperName = purchaseOperName;
	}
	public Date getSetoutTime() {
		return setoutTime;
	}
	public void setSetoutTime(Date setoutTime) {
		this.setoutTime = setoutTime;
	}
	public Date getDoingTime() {
		return doingTime;
	}
	public void setDoingTime(Date doingTime) {
		this.doingTime = doingTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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

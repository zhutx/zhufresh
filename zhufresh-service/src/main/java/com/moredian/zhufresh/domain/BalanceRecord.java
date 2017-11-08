package com.moredian.zhufresh.domain;

import java.util.Date;

public class BalanceRecord {
	
	private Long balanceRecordId;
	private Long userId;
	private Integer balanceBefore;
	private Integer balanceRefund;
	private Integer balanceAfter;
	private Long relationOrderId;
	private String relationOrderCode;
	private Long operId;
	private String operName;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getBalanceRecordId() {
		return balanceRecordId;
	}
	public void setBalanceRecordId(Long balanceRecordId) {
		this.balanceRecordId = balanceRecordId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getBalanceBefore() {
		return balanceBefore;
	}
	public void setBalanceBefore(Integer balanceBefore) {
		this.balanceBefore = balanceBefore;
	}
	public Integer getBalanceRefund() {
		return balanceRefund;
	}
	public void setBalanceRefund(Integer balanceRefund) {
		this.balanceRefund = balanceRefund;
	}
	public Integer getBalanceAfter() {
		return balanceAfter;
	}
	public void setBalanceAfter(Integer balanceAfter) {
		this.balanceAfter = balanceAfter;
	}
	public Long getRelationOrderId() {
		return relationOrderId;
	}
	public void setRelationOrderId(Long relationOrderId) {
		this.relationOrderId = relationOrderId;
	}
	public String getRelationOrderCode() {
		return relationOrderCode;
	}
	public void setRelationOrderCode(String relationOrderCode) {
		this.relationOrderCode = relationOrderCode;
	}
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

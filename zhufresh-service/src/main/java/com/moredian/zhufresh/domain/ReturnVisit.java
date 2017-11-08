package com.moredian.zhufresh.domain;

import java.util.Date;

public class ReturnVisit {
	
	private Long returnVisitId;
	private Long userId;
	private Long relationOrderId;
	private Long returnVisitOperId;
	private String returnVisitOperName;
	private Date returnVisitTime;
	private String returnVisitDesc;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getReturnVisitId() {
		return returnVisitId;
	}
	public void setReturnVisitId(Long returnVisitId) {
		this.returnVisitId = returnVisitId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRelationOrderId() {
		return relationOrderId;
	}
	public void setRelationOrderId(Long relationOrderId) {
		this.relationOrderId = relationOrderId;
	}
	public Long getReturnVisitOperId() {
		return returnVisitOperId;
	}
	public void setReturnVisitOperId(Long returnVisitOperId) {
		this.returnVisitOperId = returnVisitOperId;
	}
	public String getReturnVisitOperName() {
		return returnVisitOperName;
	}
	public void setReturnVisitOperName(String returnVisitOperName) {
		this.returnVisitOperName = returnVisitOperName;
	}
	public Date getReturnVisitTime() {
		return returnVisitTime;
	}
	public void setReturnVisitTime(Date returnVisitTime) {
		this.returnVisitTime = returnVisitTime;
	}
	public String getReturnVisitDesc() {
		return returnVisitDesc;
	}
	public void setReturnVisitDesc(String returnVisitDesc) {
		this.returnVisitDesc = returnVisitDesc;
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

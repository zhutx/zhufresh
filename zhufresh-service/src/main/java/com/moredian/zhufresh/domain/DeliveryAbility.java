package com.moredian.zhufresh.domain;

import java.util.Date;

public class DeliveryAbility {
	
	private Long deliverAbilityId;
	private Long buildingId;
	private Date theDay;
	private String fromTime;
	private String toTime;
	private Integer limitAmount;
	private Integer realAmount;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getDeliverAbilityId() {
		return deliverAbilityId;
	}
	public void setDeliverAbilityId(Long deliverAbilityId) {
		this.deliverAbilityId = deliverAbilityId;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Date getTheDay() {
		return theDay;
	}
	public void setTheDay(Date theDay) {
		this.theDay = theDay;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public Integer getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(Integer limitAmount) {
		this.limitAmount = limitAmount;
	}
	public Integer getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(Integer realAmount) {
		this.realAmount = realAmount;
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

package com.moredian.zhufresh.domain;

import java.util.Date;

public class GoodsDisplay {
	
	private Long goodsDisplayId;
	private Long buildingId;
	private Long goodsId;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getGoodsDisplayId() {
		return goodsDisplayId;
	}
	public void setGoodsDisplayId(Long goodsDisplayId) {
		this.goodsDisplayId = goodsDisplayId;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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

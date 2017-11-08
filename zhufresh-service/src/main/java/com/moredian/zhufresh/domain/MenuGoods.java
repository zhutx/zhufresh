package com.moredian.zhufresh.domain;

import java.util.Date;

public class MenuGoods {
	
	private Long menuGoodsId;
	private Long menuId;
	private Long goodsId;
	private Integer weight;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getMenuGoodsId() {
		return menuGoodsId;
	}
	public void setMenuGoodsId(Long menuGoodsId) {
		this.menuGoodsId = menuGoodsId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
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

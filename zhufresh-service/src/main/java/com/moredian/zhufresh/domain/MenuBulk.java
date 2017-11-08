package com.moredian.zhufresh.domain;

import java.util.Date;

public class MenuBulk {
	
	private Long menuBulkId;
	private Long menuId;
	private String blukName;
	private String weightText;
	private Long relationGoodsId;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getMenuBulkId() {
		return menuBulkId;
	}
	public void setMenuBulkId(Long menuBulkId) {
		this.menuBulkId = menuBulkId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getBlukName() {
		return blukName;
	}
	public void setBlukName(String blukName) {
		this.blukName = blukName;
	}
	public String getWeightText() {
		return weightText;
	}
	public void setWeightText(String weightText) {
		this.weightText = weightText;
	}
	public Long getRelationGoodsId() {
		return relationGoodsId;
	}
	public void setRelationGoodsId(Long relationGoodsId) {
		this.relationGoodsId = relationGoodsId;
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

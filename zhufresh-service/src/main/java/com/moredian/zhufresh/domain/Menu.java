package com.moredian.zhufresh.domain;

import java.util.Date;

public class Menu {
	
	private Long menuId;
	private String menuName;
	private Integer hotType;
	private Integer styleType;
	private Integer placeType;
	private Integer tasteType;
	private String menuImgUrl;
	private String keywords;
	private String menuDesc;
	private Integer status;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getHotType() {
		return hotType;
	}
	public void setHotType(Integer hotType) {
		this.hotType = hotType;
	}
	public Integer getStyleType() {
		return styleType;
	}
	public void setStyleType(Integer styleType) {
		this.styleType = styleType;
	}
	public Integer getPlaceType() {
		return placeType;
	}
	public void setPlaceType(Integer placeType) {
		this.placeType = placeType;
	}
	public Integer getTasteType() {
		return tasteType;
	}
	public void setTasteType(Integer tasteType) {
		this.tasteType = tasteType;
	}
	public String getMenuImgUrl() {
		return menuImgUrl;
	}
	public void setMenuImgUrl(String menuImgUrl) {
		this.menuImgUrl = menuImgUrl;
	}
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
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

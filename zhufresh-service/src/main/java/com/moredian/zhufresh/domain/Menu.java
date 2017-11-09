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
	private Integer menuUnit;
	private Integer menuUnitPrice;
	private Integer cookieWay;
	private Integer cookieTime;
	private Integer kaluli;
	private String menuDesc;
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
	public Integer getMenuUnit() {
		return menuUnit;
	}
	public void setMenuUnit(Integer menuUnit) {
		this.menuUnit = menuUnit;
	}
	public Integer getMenuUnitPrice() {
		return menuUnitPrice;
	}
	public void setMenuUnitPrice(Integer menuUnitPrice) {
		this.menuUnitPrice = menuUnitPrice;
	}
	public Integer getCookieWay() {
		return cookieWay;
	}
	public void setCookieWay(Integer cookieWay) {
		this.cookieWay = cookieWay;
	}
	public Integer getCookieTime() {
		return cookieTime;
	}
	public void setCookieTime(Integer cookieTime) {
		this.cookieTime = cookieTime;
	}
	public Integer getKaluli() {
		return kaluli;
	}
	public void setKaluli(Integer kaluli) {
		this.kaluli = kaluli;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
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
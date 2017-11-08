package com.moredian.zhufresh.domain;

import java.util.Date;

public class FavoriteMenu {
	
	private Long favoriteMenuId;
	private Long userId;
	private Long favoriteId;
	private Long menuId;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getFavoriteMenuId() {
		return favoriteMenuId;
	}
	public void setFavoriteMenuId(Long favoriteMenuId) {
		this.favoriteMenuId = favoriteMenuId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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

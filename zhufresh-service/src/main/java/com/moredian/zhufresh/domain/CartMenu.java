package com.moredian.zhufresh.domain;

import java.util.Date;

public class CartMenu {
	
	private Long cartMenuId;
	private Long cartId;
	private Long menuId;
	private Date gmtCreate;
	private Date gmtModify;
	
	public Long getCartMenuId() {
		return cartMenuId;
	}
	public void setCartMenuId(Long cartMenuId) {
		this.cartMenuId = cartMenuId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
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

package com.moredian.zhufresh.web.controller.favorite.request;

public class FavoriteCancelModel {

    private Long userId;
    private Long menuId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}

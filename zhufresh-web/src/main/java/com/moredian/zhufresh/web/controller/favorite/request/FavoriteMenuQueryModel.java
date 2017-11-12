package com.moredian.zhufresh.web.controller.favorite.request;

import com.moredian.zhufresh.web.model.PageModel;

public class FavoriteMenuQueryModel extends PageModel {

    private Long userId;
    private Long favoriteId;

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
}

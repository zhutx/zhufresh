package com.moredian.zhufresh.web.controller.favorite.request;

public class FavoriteCreateModel {

    private Long userId;
    private String favoriteName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFavoriteName() {
        return favoriteName;
    }

    public void setFavoriteName(String favoriteName) {
        this.favoriteName = favoriteName;
    }
}

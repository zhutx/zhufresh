package com.moredian.zhufresh.request;

import java.io.Serializable;

public class FavoriteUpdateRequest implements Serializable {

    private static final long serialVersionUID = -5455790794782824364L;

    private Long favoriteId;
    private Long userId;
    private String favoriteName;

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

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

package com.moredian.zhufresh.request;

import java.io.Serializable;

public class FavoriteCreateRequest implements Serializable {

    private static final long serialVersionUID = -7250570620773555005L;

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

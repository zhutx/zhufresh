package com.moredian.zhufresh.web.controller.cart.request;

import com.moredian.zhufresh.utils.AuthorizeUtil;

public class CartClearModel {

    private Long userId = AuthorizeUtil.getUserId();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

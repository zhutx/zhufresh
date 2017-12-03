package com.moredian.zhufresh.web.controller.cart.request;

import com.moredian.zhufresh.request.CartGoodsRequest;

import java.util.List;

public class CartUpdateModel {

    private Long userId;
    private Long cartId;
    private List<CartGoodsRequest> goods;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartGoodsRequest> getGoods() {
        return goods;
    }

    public void setGoods(List<CartGoodsRequest> goods) {
        this.goods = goods;
    }
}

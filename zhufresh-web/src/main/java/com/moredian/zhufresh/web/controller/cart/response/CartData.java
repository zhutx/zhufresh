package com.moredian.zhufresh.web.controller.cart.response;

import com.moredian.zhufresh.model.CartGoodsFullInfo;

import java.util.Date;
import java.util.List;

public class CartData {

    private Long cartId;

    private List<CartGoodsData> goods;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartGoodsData> getGoods() {
        return goods;
    }

    public void setGoods(List<CartGoodsData> goods) {
        this.goods = goods;
    }
}

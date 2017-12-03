package com.moredian.zhufresh.web.controller.cart.response;

import com.moredian.zhufresh.model.CartGoodsFullInfo;

import java.util.Date;
import java.util.List;

public class CartData {

    private Long cartId;
    private Long userId;
    private Date gmtCreate;
    private Date gmtModify;

    private List<CartGoodsData> goods;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<CartGoodsData> getGoods() {
        return goods;
    }

    public void setGoods(List<CartGoodsData> goods) {
        this.goods = goods;
    }
}

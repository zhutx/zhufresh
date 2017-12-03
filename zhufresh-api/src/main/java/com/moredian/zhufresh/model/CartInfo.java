package com.moredian.zhufresh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CartInfo implements Serializable {

    private static final long serialVersionUID = -8530380035175458204L;

    private Long cartId;
    private Long userId;
    private Date gmtCreate;
    private Date gmtModify;

    private List<CartGoodsFullInfo> goods;

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

    public List<CartGoodsFullInfo> getGoods() {
        return goods;
    }

    public void setGoods(List<CartGoodsFullInfo> goods) {
        this.goods = goods;
    }
}

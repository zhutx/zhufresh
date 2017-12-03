package com.moredian.zhufresh.model;

import java.io.Serializable;
import java.util.Date;

public class CartGoodsInfo implements Serializable {

    private static final long serialVersionUID = -6034879878993150535L;

    private Long cartGoodsId;
    private Long cartId;
    private Long goodsId;
    private Integer weight;
    private Date gmtCreate;
    private Date gmtModify;

    public Long getCartGoodsId() {
        return cartGoodsId;
    }

    public void setCartGoodsId(Long cartGoodsId) {
        this.cartGoodsId = cartGoodsId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
}

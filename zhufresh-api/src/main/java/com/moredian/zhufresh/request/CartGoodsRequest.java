package com.moredian.zhufresh.request;

import java.io.Serializable;

public class CartGoodsRequest implements Serializable {

    private static final long serialVersionUID = -5924931991986209229L;

    private Long goodsId;
    private Integer weight;

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
}

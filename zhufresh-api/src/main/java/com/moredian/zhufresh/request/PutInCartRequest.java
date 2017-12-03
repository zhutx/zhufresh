package com.moredian.zhufresh.request;

import java.io.Serializable;
import java.util.List;

public class PutInCartRequest implements Serializable {

    private static final long serialVersionUID = -5055047230192057324L;

    private Long userId;
    private List<CartGoodsRequest> goods;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartGoodsRequest> getGoods() {
        return goods;
    }

    public void setGoods(List<CartGoodsRequest> goods) {
        this.goods = goods;
    }
}

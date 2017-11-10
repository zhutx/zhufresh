package com.moredian.zhufresh.model;

import java.io.Serializable;

public class GoodsTypeInfo implements Serializable {

    private static final long serialVersionUID = -3751972638366256794L;

    private Long goodsTypeId;
    private String goodsTypeName;
    private Long parentId;

    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

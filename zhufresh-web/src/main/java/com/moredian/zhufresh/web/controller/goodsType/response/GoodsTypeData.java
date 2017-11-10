package com.moredian.zhufresh.web.controller.goodsType.response;

import java.util.ArrayList;
import java.util.List;

public class GoodsTypeData {

    private Long goodsTypeId;
    private String goodsTypeName;
    private Long parentId;
    private List<GoodsTypeData> children = new ArrayList<>();

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

    public List<GoodsTypeData> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTypeData> children) {
        this.children = children;
    }
}

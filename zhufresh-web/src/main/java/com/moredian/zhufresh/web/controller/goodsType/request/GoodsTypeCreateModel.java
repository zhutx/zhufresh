package com.moredian.zhufresh.web.controller.goodsType.request;

import org.apache.commons.lang.StringUtils;

public class GoodsTypeCreateModel {

    private String goodsTypeName;
    private Long parentId = 0L;

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        if(StringUtils.isBlank(goodsTypeName)) {
            this.goodsTypeName = null;
        } else {
            this.goodsTypeName = goodsTypeName;
        }
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

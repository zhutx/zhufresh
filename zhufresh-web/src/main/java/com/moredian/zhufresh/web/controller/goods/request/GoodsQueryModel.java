package com.moredian.zhufresh.web.controller.goods.request;

import com.moredian.zhufresh.web.model.PageModel;

public class GoodsQueryModel extends PageModel {

    private Long userId;
    private Long addressId;
    private Long goodsType1Id;
    private Long goodsType2Id;
    private String keywords;
    private Integer status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getGoodsType1Id() {
        return goodsType1Id;
    }

    public void setGoodsType1Id(Long goodsType1Id) {
        this.goodsType1Id = goodsType1Id;
    }

    public Long getGoodsType2Id() {
        return goodsType2Id;
    }

    public void setGoodsType2Id(Long goodsType2Id) {
        this.goodsType2Id = goodsType2Id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

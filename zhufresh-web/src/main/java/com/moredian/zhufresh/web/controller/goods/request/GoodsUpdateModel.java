package com.moredian.zhufresh.web.controller.goods.request;

public class GoodsUpdateModel {

    private Long goodsId;
    private String goodsName;
    private Integer goodsType1Id;
    private Integer goodsType2Id;
    private String goodsImgUrl;
    private Integer goodsUnit;
    private Integer goodsUnitPrice;
    private String keywords;
    private String goodsDesc;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType1Id() {
        return goodsType1Id;
    }

    public void setGoodsType1Id(Integer goodsType1Id) {
        this.goodsType1Id = goodsType1Id;
    }

    public Integer getGoodsType2Id() {
        return goodsType2Id;
    }

    public void setGoodsType2Id(Integer goodsType2Id) {
        this.goodsType2Id = goodsType2Id;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public Integer getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(Integer goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Integer getGoodsUnitPrice() {
        return goodsUnitPrice;
    }

    public void setGoodsUnitPrice(Integer goodsUnitPrice) {
        this.goodsUnitPrice = goodsUnitPrice;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}

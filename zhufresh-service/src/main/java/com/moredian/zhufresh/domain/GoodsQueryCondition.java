package com.moredian.zhufresh.domain;

public class GoodsQueryCondition {

    private Long goodsType1Id;
    private Long goodsType2Id;
    private String keywords;
    private Integer status;
    private Integer startRow;
    private Integer pageSize;

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

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

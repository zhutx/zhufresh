package com.moredian.zhufresh.domain;

import java.util.Date;

public class BuildingGoods {

    private Long buildingGoodsId;
    private Long buildingId;
    private Long goodsId;
    private Date gmtCreate;
    private Date gmtModify;

    public Long getBuildingGoodsId() {
        return buildingGoodsId;
    }

    public void setBuildingGoodsId(Long buildingGoodsId) {
        this.buildingGoodsId = buildingGoodsId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

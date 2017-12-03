package com.moredian.zhufresh.web.controller.building.request;

import java.util.List;

public class BuildingGoodsConfigModel {

    private Long buildingId;
    private List<Long> goodsIds;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public List<Long> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Long> goodsIds) {
        this.goodsIds = goodsIds;
    }

}

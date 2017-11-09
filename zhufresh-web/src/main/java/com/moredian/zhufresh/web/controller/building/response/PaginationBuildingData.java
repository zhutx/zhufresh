package com.moredian.zhufresh.web.controller.building.response;

import com.moredian.zhufresh.web.model.PageData;

import java.util.List;

public class PaginationBuildingData extends PageData {

    private List<BuildingData> buildings;

    public List<BuildingData> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingData> buildings) {
        this.buildings = buildings;
    }
}

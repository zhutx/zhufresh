package com.moredian.zhufresh.web.controller.building.request;

public class BuildingUpdateModel {

    private Long buildingId;
    private Integer provCode;
    private Integer cityCode;
    private Integer districtCode;
    private String buildingName;
    private String keywords;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getProvCode() {
        return provCode;
    }

    public void setProvCode(Integer provCode) {
        this.provCode = provCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

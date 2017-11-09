package com.moredian.zhufresh.request;

import java.io.Serializable;

public class BuildingCreateRequest implements Serializable {

    private static final long serialVersionUID = 1418378177842294145L;

    private Integer provCode;
    private Integer cityCode;
    private Integer districtCode;
    private String keywords;
    private String buildingName;

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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}

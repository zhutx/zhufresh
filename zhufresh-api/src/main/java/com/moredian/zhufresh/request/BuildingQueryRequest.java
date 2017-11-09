package com.moredian.zhufresh.request;

import java.io.Serializable;

public class BuildingQueryRequest implements Serializable {

    private static final long serialVersionUID = -6722415704548352774L;

    private Integer provCode;
    private Integer cityCode;
    private Integer districtCode;
    private String keywords;

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
}

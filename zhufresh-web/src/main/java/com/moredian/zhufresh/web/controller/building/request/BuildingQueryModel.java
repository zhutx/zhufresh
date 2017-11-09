package com.moredian.zhufresh.web.controller.building.request;

import com.moredian.zhufresh.web.model.PageModel;
import org.apache.commons.lang.StringUtils;

public class BuildingQueryModel extends PageModel{

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
        if (StringUtils.isBlank(keywords)) {
            this.keywords = null;
        } else {
            this.keywords = keywords;
        }
    }
}

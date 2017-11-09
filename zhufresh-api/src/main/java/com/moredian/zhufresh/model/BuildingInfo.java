package com.moredian.zhufresh.model;

import java.io.Serializable;
import java.util.Date;

public class BuildingInfo implements Serializable {

    private static final long serialVersionUID = 8362570562800275740L;

    private Long buildingId;
    private String buildingName;
    private String keywords;
    private Integer provCode;
    private Integer cityCode;
    private Integer districtCode;
    private Integer status;
    private Date gmtCreate;
    private Date gmtModify;

    public Long getBuildingId() {
        return buildingId;
    }
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
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
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
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

package com.moredian.zhufresh.web.controller.building.response;

public class DeliverConfigData {

    private Long deliverConfigId;
    private Long buildingId;
    private String theDay;
    private String fromTime;
    private String toTime;
    private Integer limitAmount;
    private Integer realAmount;

    public Long getDeliverConfigId() {
        return deliverConfigId;
    }

    public void setDeliverConfigId(Long deliverConfigId) {
        this.deliverConfigId = deliverConfigId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getTheDay() {
        return theDay;
    }

    public void setTheDay(String theDay) {
        this.theDay = theDay;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public Integer getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Integer limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Integer getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
    }
}

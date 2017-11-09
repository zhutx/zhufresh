package com.moredian.zhufresh.request;

import java.io.Serializable;
import java.util.Date;

public class DeliverConfigRequest implements Serializable {

    private static final long serialVersionUID = -8613643788026038155L;

    private Long buildingId;
    private String theDay;
    private String fromTime;
    private String toTime;
    private Integer limitAmount;

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
}

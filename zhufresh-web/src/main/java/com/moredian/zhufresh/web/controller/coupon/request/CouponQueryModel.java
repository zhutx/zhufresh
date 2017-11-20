package com.moredian.zhufresh.web.controller.coupon.request;

import com.moredian.zhufresh.web.model.PageModel;

import java.util.Date;

public class CouponQueryModel extends PageModel{

    private Date beginTime;
    private Date endTime;
    private Integer status;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

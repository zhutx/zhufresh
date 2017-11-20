package com.moredian.zhufresh.request;

import java.io.Serializable;
import java.util.Date;

public class CouponQueryRequest implements Serializable {

    private static final long serialVersionUID = 3718877887294853283L;

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

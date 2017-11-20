package com.moredian.zhufresh.web.controller.coupon.request;

import com.moredian.zhufresh.web.model.PageModel;

public class CouponQueryModel extends PageModel{

    private String useDate;
    private Integer status;

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

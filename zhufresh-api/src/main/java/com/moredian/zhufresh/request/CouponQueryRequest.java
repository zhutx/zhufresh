package com.moredian.zhufresh.request;

import java.io.Serializable;

public class CouponQueryRequest implements Serializable {

    private static final long serialVersionUID = 3718877887294853283L;

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

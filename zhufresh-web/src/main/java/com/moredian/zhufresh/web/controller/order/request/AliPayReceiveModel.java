package com.moredian.zhufresh.web.controller.order.request;

public class AliPayReceiveModel {

    private String orderCode;
    private String payCert;
    private Integer status;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayCert() {
        return payCert;
    }

    public void setPayCert(String payCert) {
        this.payCert = payCert;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

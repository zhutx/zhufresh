package com.moredian.zhufresh.web.controller.order.request;

public class OrderDispatchModel {

    private Long orderId;
    private Long operId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }
}

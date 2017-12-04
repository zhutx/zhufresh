package com.moredian.zhufresh.request;

import java.io.Serializable;

public class OrderArrivalRequest implements Serializable {

    private static final long serialVersionUID = 1937832937293278729L;

    private Long userId;
    private Long operId;
    private Long orderId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}

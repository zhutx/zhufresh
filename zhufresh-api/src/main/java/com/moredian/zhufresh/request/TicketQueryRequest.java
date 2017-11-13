package com.moredian.zhufresh.request;

import java.io.Serializable;

public class TicketQueryRequest implements Serializable {

    private static final long serialVersionUID = -6876901624013410953L;

    private Integer ticketPrice;
    private Long dispatchOperId;
    private Long bindUserId;
    private Integer longTimeFlag;
    private Integer status;

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Long getDispatchOperId() {
        return dispatchOperId;
    }

    public void setDispatchOperId(Long dispatchOperId) {
        this.dispatchOperId = dispatchOperId;
    }

    public Long getBindUserId() {
        return bindUserId;
    }

    public void setBindUserId(Long bindUserId) {
        this.bindUserId = bindUserId;
    }

    public Integer getLongTimeFlag() {
        return longTimeFlag;
    }

    public void setLongTimeFlag(Integer longTimeFlag) {
        this.longTimeFlag = longTimeFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

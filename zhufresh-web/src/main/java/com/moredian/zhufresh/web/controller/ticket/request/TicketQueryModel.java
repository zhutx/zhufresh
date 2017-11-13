package com.moredian.zhufresh.web.controller.ticket.request;

import com.moredian.zhufresh.web.model.PageModel;

public class TicketQueryModel extends PageModel {

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

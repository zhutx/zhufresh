package com.moredian.zhufresh.domain;

public class TicketQueryCondition {

    private Integer ticketPrice;
    private Long dispatchOperId;
    private Long bindUserId;
    private Integer longTimeFlag;
    private Integer status;
    private Integer startRow;
    private Integer pageSize;

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

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

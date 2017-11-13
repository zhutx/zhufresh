package com.moredian.zhufresh.request;

import java.io.Serializable;
import java.util.Date;

public class TicketCreateRequest implements Serializable {

    private static final long serialVersionUID = 8109092334496782756L;

    private Integer ticketPrice;
    private Integer longTimeFlag;
    private Date expireDate;

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getLongTimeFlag() {
        return longTimeFlag;
    }

    public void setLongTimeFlag(Integer longTimeFlag) {
        this.longTimeFlag = longTimeFlag;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}

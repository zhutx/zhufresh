package com.moredian.zhufresh.web.controller.ticket.request;

public class TicketLongTimeBatchCreateModel {

    private Integer ticketPrice;
    private Integer amount;

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

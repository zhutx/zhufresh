package com.moredian.zhufresh.web.controller.ticket.request;

public class TicketBindUserModel {

    private Long userId;
    private String ticketCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}

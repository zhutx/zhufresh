package com.moredian.zhufresh.web.controller.ticket.request;

import java.util.List;

public class TicketDispatchModel {

    private List<Long> ticketIds;
    private Long operId;

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }
}

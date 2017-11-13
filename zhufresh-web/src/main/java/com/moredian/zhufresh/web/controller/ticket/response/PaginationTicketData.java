package com.moredian.zhufresh.web.controller.ticket.response;

import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.web.model.PageData;

import java.util.List;

public class PaginationTicketData extends PageData {

    private List<TicketData> tickets;

    public List<TicketData> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketData> tickets) {
        this.tickets = tickets;
    }
}

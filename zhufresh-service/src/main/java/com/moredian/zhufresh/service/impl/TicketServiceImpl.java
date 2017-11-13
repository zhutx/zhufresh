package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.service.TicketService;

import java.util.List;

@SI
public class TicketServiceImpl implements TicketService {

    @Override
    public ServiceResponse<Boolean> batchCreateLongTimeTicket(Integer ticketPrice, Integer amount) {
        return null;
    }

    @Override
    public ServiceResponse<Boolean> batchCreateExpireTicket(Integer ticketPrice, Integer amount, String expireDate) {
        return null;
    }

    @Override
    public ServiceResponse<Boolean> dispatch(List<Long> ticketIds, Long operId) {
        return null;
    }

    @Override
    public String genQRCode(Long ticketId) {
        return null;
    }

    @Override
    public ServiceResponse<Boolean> bindUser(Long userId, String ticketCode) {
        return null;
    }
}

package com.moredian.zhufresh.manager;

import com.moredian.bee.common.rpc.ServiceResponse;

import java.util.List;

public interface TicketManager {

    boolean batchCreateLongTimeTicket(Integer ticketPrice, Integer amount);

    boolean batchCreateExpireTicket(Integer ticketPrice, Integer amount, String expireDate);

    boolean dispatch(List<Long> ticketIds, Long operId);

    String genQRCode(Long ticketId);

    boolean bindUser(Long userId, String ticketCode);

}

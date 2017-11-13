package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.request.TicketCreateRequest;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * 菜票服务
 * @author zhutx
 *
 */
public interface TicketService {

    ServiceResponse<Boolean> batchCreateLongTimeTicket(Integer ticketPrice, Integer amount);

    ServiceResponse<Boolean> batchCreateExpireTicket(Integer ticketPrice, Integer amount, String expireDate);

    ServiceResponse<Boolean> dispatch(List<Long> ticketIds, Long operId);

    String genQRCode(Long ticketId);

    ServiceResponse<Boolean> bindUser(Long userId, String ticketCode);

}

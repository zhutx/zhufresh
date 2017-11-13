package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.TicketCreateRequest;
import com.moredian.zhufresh.request.TicketQueryRequest;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * 菜票服务
 * @author zhutx
 *
 */
public interface TicketService {

    ServiceResponse<Boolean> batchCreateLongTimeTicket(Integer ticketPrice, Integer amount);

    ServiceResponse<Boolean> batchCreateCanBeExpireTicket(Integer ticketPrice, Integer amount, String expireDate);

    ServiceResponse<Boolean> dispatch(List<Long> ticketIds, Long operId);

    List<TicketInfo> searchDispatchTicket(Long operId);

    ServiceResponse<Boolean> bindUser(Long userId, String ticketCode);

    List<TicketInfo> findUserTicket(Long userId);

    Pagination<TicketInfo> searchTicket(TicketQueryRequest request, Pagination<TicketInfo> pagination);

}

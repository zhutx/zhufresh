package com.moredian.zhufresh.manager;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.TicketQueryRequest;

import java.util.List;

public interface TicketManager {

    boolean batchCreateLongTimeTicket(Integer ticketPrice, Integer amount);

    boolean batchCreateCanBeExpireTicket(Integer ticketPrice, Integer amount, String expireDate);

    boolean dispatch(List<Long> ticketIds, Long operId);

    List<Ticket> searchDispatchTicket(Long operId);

    boolean bindUser(Long userId, String ticketCode);

    List<Ticket> findUserTicket(Long userId);

    boolean useTicket(Long userId, Long ticketId);

    PaginationDomain<Ticket> searchTicket(TicketQueryRequest request, Pagination<TicketInfo> pagination);

    boolean autoExpire();

}

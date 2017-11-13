package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.manager.TicketManager;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.TicketQueryRequest;
import com.moredian.zhufresh.service.TicketService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@SI
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketManager ticketManager;

    @Override
    public ServiceResponse<Boolean> batchCreateLongTimeTicket(Integer ticketPrice, Integer amount) {
        boolean result = ticketManager.batchCreateLongTimeTicket(ticketPrice, amount);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> batchCreateCanBeExpireTicket(Integer ticketPrice, Integer amount, String expireDate) {
        boolean result = ticketManager.batchCreateCanBeExpireTicket(ticketPrice, amount, expireDate);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> dispatch(List<Long> ticketIds, Long operId) {
        boolean result = ticketManager.dispatch(ticketIds, operId);
        return new ServiceResponse<>(true, null, result);
    }

    private List<TicketInfo> ticketsToTicketInfos(List<Ticket> tickets) {
        if (CollectionUtils.isEmpty(tickets)) return new ArrayList<>();
        return BeanUtils.copyListProperties(TicketInfo.class, tickets);
    }

    @Override
    public List<TicketInfo> searchDispatchTicket(Long operId) {
        List<Ticket> tickets = ticketManager.searchDispatchTicket(operId);
        return ticketsToTicketInfos(tickets);
    }

    @Override
    public ServiceResponse<Boolean> bindUser(Long userId, String ticketCode) {
        boolean result = ticketManager.bindUser(userId, ticketCode);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public List<TicketInfo> findUserTicket(Long userId) {
        List<Ticket> tickets = ticketManager.findUserTicket(userId);
        return ticketsToTicketInfos(tickets);
    }

    private List<TicketInfo> ticketListToTicketInfoList(List<Ticket> ticketList) {
        if(CollectionUtils.isEmpty(ticketList)) return new ArrayList<>();
        return BeanUtils.copyListProperties(TicketInfo.class, ticketList);
    }

    private Pagination<TicketInfo> paginationDomainToPagination(PaginationDomain<Ticket> fromPagination) {
        Pagination<TicketInfo> toPagination = PaginationConvertor.paginationDomainToPagination(fromPagination, new Pagination<TicketInfo>());
        if (toPagination == null)
            return null;
        toPagination.setData(ticketListToTicketInfoList(fromPagination.getData()));
        return toPagination;
    }

    @Override
    public Pagination<TicketInfo> searchTicket(TicketQueryRequest request, Pagination<TicketInfo> pagination) {
        PaginationDomain<Ticket> paginationDomain = ticketManager.searchTicket(request, pagination);
        return paginationDomainToPagination(paginationDomain);
    }
}

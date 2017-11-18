package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.common.exception.BizAssert;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.ExceptionUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.convertor.PaginationConvertor;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.dto.BatchIdDto;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.domain.Menu;
import com.moredian.zhufresh.domain.MenuQueryCondition;
import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.domain.TicketQueryCondition;
import com.moredian.zhufresh.enums.TicketStatus;
import com.moredian.zhufresh.enums.YesNoFlag;
import com.moredian.zhufresh.enums.ZhufreshErrorCode;
import com.moredian.zhufresh.manager.TicketManager;
import com.moredian.zhufresh.mapper.TicketMapper;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.TicketQueryRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TicketManagerImpl implements TicketManager {

    @Autowired
    private TicketMapper ticketMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private BatchIdDto genBatchPrimaryKey(String name, int amount) {
        return idgeneratorService.getNextIdBatchBytypeName(name, amount).getData();
    }

    @Override
    @Transactional
    public boolean batchCreateLongTimeTicket(Integer ticketPrice, Integer amount) {
        BizAssert.notNull(ticketPrice, "tickePrice is required");
        BizAssert.notNull(amount, "amount is required");

        BatchIdDto batchIdDto = genBatchPrimaryKey(Ticket.class.getName(), amount);

        for (int i = 0; i < amount; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(batchIdDto.nextId());
            ticket.setTicketCode(RandomStringUtils.randomAlphanumeric(16));
            Date expireDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                expireDate = sdf.parse("2100-12-31");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ticket.setExpireDate(expireDate);
            ticket.setLongTimeFlag(YesNoFlag.YES.getValue());
            ticket.setTicketPrice(ticketPrice);
            ticket.setStatus(TicketStatus.NEW.getValue());
            ticketMapper.insert(ticket);
        }

        return true;
    }

    @Override
    public boolean batchCreateCanBeExpireTicket(Integer ticketPrice, Integer amount, String expireDateStr) {
        BizAssert.notNull(ticketPrice, "tickePrice is required");
        BizAssert.notNull(amount, "amount is required");
        BizAssert.notBlank(expireDateStr, "expiredDate is required");

        BatchIdDto batchIdDto = genBatchPrimaryKey(Ticket.class.getName(), amount);

        for (int i = 0; i < amount; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketId(batchIdDto.nextId());
            ticket.setTicketCode(RandomStringUtils.randomAlphanumeric(16));
            Date expireDate = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                expireDate = sdf.parse(expireDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ticket.setExpireDate(expireDate);
            ticket.setLongTimeFlag(YesNoFlag.NO.getValue());
            ticket.setTicketPrice(ticketPrice);
            ticket.setStatus(TicketStatus.NEW.getValue());
            ticketMapper.insert(ticket);
        }

        return true;
    }

    @Override
    public boolean dispatch(List<Long> ticketIds, Long operId) {
        BizAssert.notEmpty(ticketIds);
        BizAssert.notNull(operId, "operId is required");

        String operName = null;

        ticketMapper.updateDispatchOperIdByIds(operId, operName, ticketIds, TicketStatus.NEW.getValue(), TicketStatus.DISPATCH.getValue());

        return true;
    }

    @Override
    public List<Ticket> searchDispatchTicket(Long operId) {
        BizAssert.notNull(operId, "operId is required");
        return ticketMapper.findByDispatchOperId(operId, TicketStatus.DISPATCH.getValue());
    }

    @Override
    public boolean bindUser(Long userId, String ticketCode) {

        BizAssert.notNull(userId, "userId is required");
        BizAssert.notBlank(ticketCode, "ticketCode is required");

        Ticket ticket = ticketMapper.loadByCode(ticketCode);
        if (ticket.getStatus() != TicketStatus.DISPATCH.getValue()) {
            ExceptionUtils.throwException(ZhufreshErrorCode.TICKET_STATUS_FAIL, ZhufreshErrorCode.TICKET_STATUS_FAIL.getMessage());
        }

        ticketMapper.updateBindUserId(ticket.getTicketId(), userId, TicketStatus.UNUSED.getValue());

        return true;
    }

    @Override
    public List<Ticket> findUserTicket(Long userId) {
        BizAssert.notNull(userId, "userId is required");
        return ticketMapper.findTicketByUserId(userId, TicketStatus.UNUSED.getValue());
    }

    @Override
    public boolean useTicket(Long userId, Long ticketId) {
        BizAssert.notNull(userId, "userId is required");
        BizAssert.notNull(ticketId, "ticketId is required");

        Ticket ticket = ticketMapper.load(ticketId);
        if (ticket.getStatus() != TicketStatus.UNUSED.getValue()) {
            ExceptionUtils.throwException(ZhufreshErrorCode.TICKET_STATUS_FAIL, ZhufreshErrorCode.TICKET_STATUS_FAIL.getMessage());
        }
        if (ticket.getBindUserId().longValue() != userId.longValue()) {
            ExceptionUtils.throwException(ZhufreshErrorCode.NOT_YOUR_TICKET, ZhufreshErrorCode.NOT_YOUR_TICKET.getMessage());
        }

        ticketMapper.updateStatus(ticketId, TicketStatus.USED.getValue());

        return true;
    }

    private TicketQueryCondition requestToCondition(TicketQueryRequest request) {
        return BeanUtils.copyProperties(TicketQueryCondition.class, request);
    }

    private PaginationDomain<Ticket> paginationToPaginationDomain(Pagination<TicketInfo> pagination) {
        return PaginationConvertor.paginationToPaginationDomain(pagination, new PaginationDomain<Ticket>());
    }

    private PaginationDomain getPagination(PaginationDomain paginationDomain, TicketQueryCondition queryCondition) {
        int totalCount = ticketMapper.getTotalCountByCondition(queryCondition);
        paginationDomain.setTotalCount(totalCount);
        if (totalCount > 0) {
            queryCondition.setStartRow(paginationDomain.getStartRow());
            queryCondition.setPageSize(paginationDomain.getPageSize());
            paginationDomain.setData(ticketMapper.findPaginationByCondition(queryCondition));
        }
        return paginationDomain;
    }

    @Override
    public PaginationDomain<Ticket> searchTicket(TicketQueryRequest request, Pagination<TicketInfo> pagination) {
        TicketQueryCondition queryCondition = requestToCondition(request);

        PaginationDomain<Ticket> paginationDomain = paginationToPaginationDomain(pagination);

        return this.getPagination(paginationDomain, queryCondition);
    }

    @Override
    public boolean autoExpire() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date expireDate = cal.getTime();

        ticketMapper.updateStatusForExpire(TicketStatus.DISPATCH.getValue(), TicketStatus.EXPIRE.getValue(), expireDate);

        return true;
    }

}

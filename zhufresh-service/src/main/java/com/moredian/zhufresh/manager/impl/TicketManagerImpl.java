package com.moredian.zhufresh.manager.impl;

import com.moredian.bee.tube.annotation.SI;
import com.moredian.idgenerator.service.IdgeneratorService;
import com.moredian.zhufresh.manager.TicketManager;
import com.moredian.zhufresh.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketManagerImpl implements TicketManager {

    @Autowired
    private TicketMapper ticketMapper;
    @SI
    private IdgeneratorService idgeneratorService;

    private Long genPrimaryKey(String name) {
        return idgeneratorService.getNextIdByTypeName(name).getData();
    }

    @Override
    public boolean batchCreateLongTimeTicket(Integer ticketPrice, Integer amount) {
        return false;
    }

    @Override
    public boolean batchCreateExpireTicket(Integer ticketPrice, Integer amount, String expireDate) {
        return false;
    }

    @Override
    public boolean dispatch(List<Long> ticketIds, Long operId) {
        return false;
    }

    @Override
    public String genQRCode(Long ticketId) {
        return null;
    }

    @Override
    public boolean bindUser(Long userId, String ticketCode) {
        return false;
    }
}

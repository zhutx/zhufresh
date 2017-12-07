package com.moredian.zhufresh.web.controller.ticket;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.model.MenuInfo;
import com.moredian.zhufresh.model.TicketInfo;
import com.moredian.zhufresh.request.MenuCreateRequest;
import com.moredian.zhufresh.request.MenuQueryRequest;
import com.moredian.zhufresh.request.TicketQueryRequest;
import com.moredian.zhufresh.service.TicketService;
import com.moredian.zhufresh.utils.AuthorizeUtil;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.menu.request.MenuCreateModel;
import com.moredian.zhufresh.web.controller.menu.request.MenuQueryModel;
import com.moredian.zhufresh.web.controller.menu.response.MenuData;
import com.moredian.zhufresh.web.controller.menu.response.PaginationMenuData;
import com.moredian.zhufresh.web.controller.ticket.request.*;
import com.moredian.zhufresh.web.controller.ticket.response.PaginationTicketData;
import com.moredian.zhufresh.web.controller.ticket.response.TicketData;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/ticket")
public class TicketController extends BaseController {

    @SI
    private TicketService ticketService;

    @RequestMapping(value="/longTime/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse batchCreateLongTimeTicket(@RequestBody TicketLongTimeBatchCreateModel model) {
        ticketService.batchCreateLongTimeTicket(model.getTicketPrice(), model.getAmount()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/expire/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse batchCreateCanBeExpireTicket(@RequestBody TicketCanBeExpireBatchCreateModel model) {
        ticketService.batchCreateCanBeExpireTicket(model.getTicketPrice(), model.getAmount(), model.getExpireDate()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/dispatch", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse dispatchTicket(@RequestBody TicketDispatchModel model) {
        ticketService.dispatch(model.getTicketIds(), model.getOperId()).pickDataThrowException();
        return new BaseResponse();
    }

    private List<TicketData> ticketInfosToTicketDatas(List<TicketInfo> ticketInfos) {
        if (CollectionUtils.isEmpty(ticketInfos)) return new ArrayList<>();
        return BeanUtils.copyListProperties(TicketData.class, ticketInfos);
    }

    @RequestMapping(value="/dispatch", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse searchDispatchTicket(@RequestParam(value = "operId") Long operId) {

        List<TicketInfo> ticketInfos = ticketService.searchDispatchTicket(operId);
        BaseResponse<List<TicketData>> br = new BaseResponse<>();
        br.setData(ticketInfosToTicketDatas(ticketInfos));
        return br;

    }

    @RequestMapping(value="/bind", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse bindTicket(@RequestBody TicketBindUserModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        ticketService.bindUser(model.getUserId(), model.getTicketCode()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/user/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse findUserTicket() {

        List<TicketInfo> ticketInfos = ticketService.findUserTicket(AuthorizeUtil.getUserId());
        BaseResponse<List<TicketData>> br = new BaseResponse<>();
        br.setData(ticketInfosToTicketDatas(ticketInfos));
        return br;

    }

    private TicketQueryRequest buildRequest(TicketQueryModel model) {
        return BeanUtils.copyProperties(TicketQueryRequest.class, model);
    }

    private Pagination<TicketInfo> buildPagination(int pageNo, int pageSize) {
        Pagination<TicketInfo> pagination = new Pagination<>();
        pagination.setPageNo(pageNo);
        pagination.setPageSize(pageSize);
        return pagination;
    }

    private PaginationTicketData paginationToPaginationData(Pagination<TicketInfo> pagination) {
        PaginationTicketData data = new PaginationTicketData();
        data.setPageNo(pagination.getPageNo());
        data.setTotalCount(pagination.getTotalCount());
        data.setTickets(BeanUtils.copyListProperties(TicketData.class, pagination.getData()));
        return data;
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "ticketPrice", required = false) Integer ticketPrice, @RequestParam(value = "dispatchOperId", required = false) Long dispatchOperId, @RequestParam(value = "bindUserId", required = false) Long bindUserId, @RequestParam(value = "longTimeFlag", required = false) Integer longTimeFlag, @RequestParam(value = "status", required = false) Integer status) {

        TicketQueryModel model = new TicketQueryModel();
        model.setBindUserId(bindUserId);
        model.setDispatchOperId(dispatchOperId);
        model.setLongTimeFlag(longTimeFlag);
        model.setTicketPrice(ticketPrice);
        model.setStatus(status);

        Pagination<TicketInfo> pagination = ticketService.searchTicket(this.buildRequest(model), this.buildPagination(model.getPageNo(), model.getPageSize()));
        BaseResponse<PaginationTicketData> br = new BaseResponse<>();
        br.setData(paginationToPaginationData(pagination));
        return br;

    }

}
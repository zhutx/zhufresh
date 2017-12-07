package com.moredian.zhufresh.web.controller.order;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.enums.PayWay;
import com.moredian.zhufresh.enums.YesNoFlag;
import com.moredian.zhufresh.request.OrderArrivalRequest;
import com.moredian.zhufresh.request.OrderCommentRequest;
import com.moredian.zhufresh.request.OrderCreateRequest;
import com.moredian.zhufresh.service.OrderService;
import com.moredian.zhufresh.utils.AuthorizeUtil;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.order.request.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/order")
public class OrderController extends BaseController {

    @SI
    private OrderService orderService;

    private OrderCreateRequest buildRequest(OrderCreateModel model) {
        return BeanUtils.copyProperties(OrderCreateRequest.class, model);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse create(@RequestBody OrderCreateModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        ServiceResponse<Long> sr = orderService.createOrder(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }

    @RequestMapping(value="/alipay", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse alipay(@RequestBody AliPayReceiveModel model) {
        if(model.getStatus() == YesNoFlag.YES.getValue()) {
            orderService.updateByPay(model.getOrderCode(), PayWay.ALIPAY.getValue(), model.getPayCert());
        }
        return new BaseResponse();
    }

    private OrderArrivalRequest buildRequest(OrderArrivalModel model) {
        return BeanUtils.copyProperties(OrderArrivalRequest.class, model);
    }

    @RequestMapping(value="/dispatch", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse arrival(@RequestBody OrderDispatchModel model) {
        orderService.dispatch(model.getOrderId(), model.getOperId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/deliver", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse deliver(@RequestBody OrderDeliverModel model) {
        orderService.deliver(model.getOrderId()).pickDataThrowException();
        return new BaseResponse();
    }

    @RequestMapping(value="/arrival", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse arrival(@RequestBody OrderArrivalModel model) {
        model.setUserId(AuthorizeUtil.getUserId()); // TODO 配送员操作的话，这句删掉就可以了
        orderService.arrival(buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }

    private OrderCommentRequest buildRequest(OrderCommentModel model) {
        return BeanUtils.copyProperties(OrderCommentRequest.class, model);
    }

    @RequestMapping(value="/comment", method= RequestMethod.POST)
    @ResponseBody
    public BaseResponse comment(@RequestBody OrderCommentModel model) {
        model.setUserId(AuthorizeUtil.getUserId());
        orderService.comment(buildRequest(model)).pickDataThrowException();
        return new BaseResponse();
    }


}

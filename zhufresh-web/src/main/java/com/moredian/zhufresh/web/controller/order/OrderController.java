package com.moredian.zhufresh.web.controller.order;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.BeanUtils;
import com.moredian.bee.common.web.BaseResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.request.OrderCreateRequest;
import com.moredian.zhufresh.service.OrderService;
import com.moredian.zhufresh.web.BaseController;
import com.moredian.zhufresh.web.controller.order.request.OrderCreateModel;
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
        ServiceResponse<Long> sr = orderService.createOrder(this.buildRequest(model));
        if (!sr.isSuccess()) sr.pickDataThrowException();
        BaseResponse<Long> br = new BaseResponse<>();
        br.setData(sr.getData());
        return br;
    }


}

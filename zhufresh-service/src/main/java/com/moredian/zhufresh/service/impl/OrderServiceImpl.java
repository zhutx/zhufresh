package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.manager.OrderManager;
import com.moredian.zhufresh.request.OrderCreateRequest;
import com.moredian.zhufresh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

@SI
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderManager orderManager;

    @Override
    public ServiceResponse<Long> createOrder(OrderCreateRequest request) {
        Long result = orderManager.addOrder(request);
        return new ServiceResponse<>(true, null, result);
    }
}

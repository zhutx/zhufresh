package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.enums.PayWay;
import com.moredian.zhufresh.manager.OrderManager;
import com.moredian.zhufresh.request.OrderArrivalRequest;
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

    @Override
    public ServiceResponse<Boolean> updateByPay(String orderCode, Integer payWay, String payCert) {
        boolean result = orderManager.updateByPay(orderCode, payWay, payCert);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> dispatch(Long orderId, Long operId) {
        boolean result = orderManager.dispatch(orderId, operId);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> deliver(Long orderId) {
        boolean result = orderManager.deliver(orderId);
        return new ServiceResponse<>(true, null, result);
    }

    @Override
    public ServiceResponse<Boolean> arrival(OrderArrivalRequest request) {
        boolean result = orderManager.arrival(request);
        return new ServiceResponse<>(true, null, result);
    }
}

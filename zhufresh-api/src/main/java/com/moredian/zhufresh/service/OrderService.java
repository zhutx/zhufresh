package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.request.OrderCreateRequest;

/**
 * 订单服务
 * @author zhutx
 *
 */
public interface OrderService {

    ServiceResponse<Long> createOrder(OrderCreateRequest request);

    ServiceResponse<Boolean> updateByPay(String orderCode, Integer payWay, String payCert);

}

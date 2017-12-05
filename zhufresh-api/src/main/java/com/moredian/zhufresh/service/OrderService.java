package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.request.OrderArrivalRequest;
import com.moredian.zhufresh.request.OrderCommentRequest;
import com.moredian.zhufresh.request.OrderCreateRequest;

/**
 * 订单服务
 * @author zhutx
 *
 */
public interface OrderService {

    ServiceResponse<Long> createOrder(OrderCreateRequest request);

    ServiceResponse<Boolean> updateByPay(String orderCode, Integer payWay, String payCert);

    ServiceResponse<Boolean> dispatch(Long orderId, Long operId);

    ServiceResponse<Boolean> deliver(Long orderId);

    ServiceResponse<Boolean> arrival(OrderArrivalRequest request);

    ServiceResponse<Boolean> comment(OrderCommentRequest request);

}

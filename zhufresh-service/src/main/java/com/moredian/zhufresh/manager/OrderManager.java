package com.moredian.zhufresh.manager;

import com.moredian.zhufresh.request.OrderCreateRequest;

public interface OrderManager {

    Long addOrder(OrderCreateRequest request);

}

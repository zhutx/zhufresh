package com.moredian.zhufresh.service.impl;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.tube.annotation.SI;
import com.moredian.zhufresh.manager.CartManager;
import com.moredian.zhufresh.mapper.CartMapper;
import com.moredian.zhufresh.request.PutInCartRequest;
import com.moredian.zhufresh.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

@SI
public class CartServiceImpl implements CartService {

    @Autowired
    private CartManager cartManager;

    @Override
    public ServiceResponse<Boolean> putIn(PutInCartRequest request) {
        boolean result = cartManager.putIn(request);
        return new ServiceResponse<>(true, null, result);
    }
}

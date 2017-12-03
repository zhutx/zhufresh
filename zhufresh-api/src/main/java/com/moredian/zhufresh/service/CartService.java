package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.model.CartInfo;
import com.moredian.zhufresh.request.CartUpdateRequest;
import com.moredian.zhufresh.request.PutInCartRequest;

/**
 * 菜篮服务
 * @author zhutx
 *
 */
public interface CartService {

    ServiceResponse<Boolean> putIn(PutInCartRequest request);

    ServiceResponse<Boolean> clear(Long userId);

    ServiceResponse<Boolean> update(CartUpdateRequest request);

    CartInfo getCartInfo(Long userId);

}

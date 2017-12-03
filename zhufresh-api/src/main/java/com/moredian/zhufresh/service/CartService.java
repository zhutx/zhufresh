package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.zhufresh.request.PutInCartRequest;

/**
 * 菜篮服务
 * @author zhutx
 *
 */
public interface CartService {

    ServiceResponse<Boolean> putIn(PutInCartRequest request);

    ServiceResponse<Boolean> clear(Long userId);

}

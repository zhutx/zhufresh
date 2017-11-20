package com.moredian.zhufresh.service;

import com.moredian.bee.common.rpc.ServiceResponse;
import com.moredian.bee.common.utils.Pagination;
import com.moredian.zhufresh.model.CouponInfo;
import com.moredian.zhufresh.request.CouponQueryRequest;

/**
 * 优惠服务
 * @author zhutx
 *
 */
public interface CouponService {

    ServiceResponse<Boolean> batchCreateCoupon(Integer couponPrice, Integer amount);

    ServiceResponse<Boolean> bindUser(Long userId, String couponCode);

    Pagination<CouponInfo> searchCoupon(CouponQueryRequest request, Pagination<CouponInfo> pagination);

    CouponInfo getOneCoupon(Long userId);

}

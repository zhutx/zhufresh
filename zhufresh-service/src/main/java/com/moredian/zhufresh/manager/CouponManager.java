package com.moredian.zhufresh.manager;

import com.moredian.bee.common.utils.Pagination;
import com.moredian.bee.mybatis.domain.PaginationDomain;
import com.moredian.zhufresh.domain.Coupon;
import com.moredian.zhufresh.model.CouponInfo;
import com.moredian.zhufresh.request.CouponQueryRequest;

public interface CouponManager {

    boolean batchCreateCoupon(Integer couponPrice, Integer amount);

    boolean bindUser(Long userId, String couponCode);

    PaginationDomain<Coupon> searchCoupon(CouponQueryRequest request, Pagination<CouponInfo> pagination);

    Coupon getOneCoupon(Long userId);

    boolean autoExpire();

    Coupon getCouponByCode(Long userId, String couponCode);

    boolean updateByUse(Long couponId, Long orderId, String orderCode);

}

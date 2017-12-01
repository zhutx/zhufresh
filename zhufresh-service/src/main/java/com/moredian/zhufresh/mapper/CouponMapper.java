package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Coupon;
import com.moredian.zhufresh.domain.CouponQueryCondition;
import com.moredian.zhufresh.domain.Goods;
import com.moredian.zhufresh.domain.GoodsQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CouponMapper {

    int insert(Coupon coupon);

    Coupon loadByCode(@Param("couponCode") String couponCode);

    int bindUser(Coupon coupon);

    Coupon loadForUse(@Param("bindUserId") Long userId, @Param("status") Integer status);

    int updateByUse(@Param("couponId") Long couponId, @Param("bindUserId") Long userId, @Param("orderId") Long orderId, @Param("useTime") Date useTime, @Param("status") Integer status);

    int updateByExpire(@Param("status") Integer status);

    int getTotalCountByCondition(CouponQueryCondition condition);

    List<Coupon> findPaginationByCondition(CouponQueryCondition condition);

    Coupon loadByCodeForUser(@Param("bindUserId") Long userId, @Param("couponCode") String couponCode, @Param("status") Integer status);

}
